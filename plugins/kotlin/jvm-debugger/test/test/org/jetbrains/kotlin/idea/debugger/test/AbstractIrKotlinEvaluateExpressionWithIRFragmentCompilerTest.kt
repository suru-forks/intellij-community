/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.debugger.test

import org.jetbrains.kotlin.config.JvmClosureGenerationScheme

abstract class AbstractIrKotlinEvaluateExpressionWithIRFragmentCompilerTest : AbstractKotlinEvaluateExpressionTest() {
    override fun useIrBackend(): Boolean = true
    override fun fragmentCompilerBackend() =
        FragmentCompilerBackend.JVM_IR
}

abstract class AbstractK1IdeK2CodeKotlinEvaluateExpressionTest : AbstractIrKotlinEvaluateExpressionWithIRFragmentCompilerTest() {
    override val compileWithK2 = true

    override fun lambdasGenerationScheme() = JvmClosureGenerationScheme.INDY
}
