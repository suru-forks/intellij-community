// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.kotlin.idea.inspections

import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.ApiStatus
import org.jetbrains.kotlin.descriptors.CallableDescriptor
import org.jetbrains.kotlin.idea.base.projectStructure.languageVersionSettings
import org.jetbrains.kotlin.idea.base.resources.KotlinBundle
import org.jetbrains.kotlin.idea.caches.resolve.findModuleDescriptor
import org.jetbrains.kotlin.idea.intentions.getArguments
import org.jetbrains.kotlin.idea.intentions.receiverType
import org.jetbrains.kotlin.idea.statistics.KotlinLanguageFeaturesFUSCollector
import org.jetbrains.kotlin.idea.statistics.NewAndDeprecatedFeaturesInspectionData
import org.jetbrains.kotlin.idea.util.RangeKtExpressionType
import org.jetbrains.kotlin.idea.util.RangeKtExpressionType.RANGE_UNTIL
import org.jetbrains.kotlin.idea.util.RangeKtExpressionType.UNTIL
import org.jetbrains.kotlin.idea.util.WasExperimentalOptInsNecessityCheckerFe10
import org.jetbrains.kotlin.idea.util.projectStructure.module
import org.jetbrains.kotlin.incremental.components.NoLookupLocation
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.nj2k.EXPERIMENTAL_STDLIB_API_ANNOTATION
import org.jetbrains.kotlin.nj2k.areKotlinVersionsSufficientToUseRangeUntil
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.createExpressionByPattern
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.calls.util.getResolvedCall
import org.jetbrains.kotlin.resolve.checkers.OptInUsageChecker.Companion.isOptInAllowed

/**
 * Tests:
 * [org.jetbrains.kotlin.idea.inspections.LocalInspectionTestGenerated.ReplaceUntilWithRangeUntil]
 */
class ReplaceUntilWithRangeUntilInspection : AbstractRangeInspection(
    collector = KotlinLanguageFeaturesFUSCollector.rangeUntilCollector,
    defaultDeprecationData = NewAndDeprecatedFeaturesInspectionData()
) {
    override fun visitRange(
        range: KtExpression,
        context: Lazy<BindingContext>,
        type: RangeKtExpressionType,
        holder: ProblemsHolder,
        session: LocalInspectionToolSession
    ) {
        if (range.isPossibleToUseRangeUntil(context)) {
            session.updateDeprecationData {
                when (type) {
                    UNTIL -> it.withDeprecatedFeature()
                    RANGE_UNTIL -> it.withNewFeature()
                    else -> it
                }
            }
            if (type != UNTIL) return

            holder.registerProblem(
                range,
                KotlinBundle.message("until.can.be.replaced.with.rangeUntil.operator"),
                ReplaceFix()
            )
        }
    }

    private class ReplaceFix : LocalQuickFix {
        override fun getFamilyName() = KotlinBundle.message("replace.with.0.operator", "..<")

        override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
            val element = descriptor.psiElement as? KtExpression ?: return
            val (left, right) = element.getArguments() ?: return
            if (left == null || right == null) return
            KotlinLanguageFeaturesFUSCollector.rangeUntilCollector.logQuickFixApplied(element.containingFile)
            element.replace(KtPsiFactory(project).createExpressionByPattern("$0..<$1", left, right))
        }
    }

    companion object {
        @ApiStatus.Internal
        fun KtElement.isPossibleToUseRangeUntil(context: Lazy<BindingContext>?): Boolean {
            val annotationFqName = FqName(EXPERIMENTAL_STDLIB_API_ANNOTATION)
            val languageVersionSettings = languageVersionSettings
            return module?.let { languageVersionSettings.areKotlinVersionsSufficientToUseRangeUntil(it, project) } == true &&
                    context?.let {
                        !isOtpInRequiredForRangeUntil(annotationFqName, it.value) ||
                                isOptInAllowed(annotationFqName, languageVersionSettings, it.value)
                    } == true
        }

        private fun KtElement.isOtpInRequiredForRangeUntil(annotationFqName: FqName, context: BindingContext): Boolean {
            val rangeUntilFunctionDescriptor = findRangeUntilFunctionDescriptor(context)
                ?: return false
            if (rangeUntilFunctionDescriptor.annotations.hasAnnotation(annotationFqName)) {
                return true
            }
            val necessaryOptIns = WasExperimentalOptInsNecessityCheckerFe10.getNecessaryOptInsFromWasExperimental(
                rangeUntilFunctionDescriptor.annotations, findModuleDescriptor(), languageVersionSettings.apiVersion
            )
            return annotationFqName in necessaryOptIns
        }

        private fun KtElement.findRangeUntilFunctionDescriptor(context: BindingContext): CallableDescriptor? {
            val descriptor = getResolvedCall(context)?.resultingDescriptor
            val receiverType = descriptor?.receiverType() ?: return null

            // Opt-in will be removed simultaneously on all rangeUntil, so no need to search for matching overload.
            return receiverType.memberScope
                .getContributedFunctions(Name.identifier("rangeUntil"), NoLookupLocation.FROM_IDE)
                .firstOrNull { it.isOperator }
        }
    }
}
