// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.workspace.storage.testEntities.entities

import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion

import com.intellij.platform.workspace.storage.WorkspaceEntity
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import com.intellij.platform.workspace.storage.ObjBuilder
import com.intellij.platform.workspace.storage.Type
import com.intellij.platform.workspace.storage.annotations.Child
import com.intellij.platform.workspace.storage.MutableEntityStorage



interface ParentNullableEntity : WorkspaceEntity {
  val parentData: String

  @Child
  val child: ChildNullableEntity?

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ParentNullableEntity, WorkspaceEntity.Builder<ParentNullableEntity>, ObjBuilder<ParentNullableEntity> {
    override var entitySource: EntitySource
    override var parentData: String
    override var child: ChildNullableEntity?
  }

  companion object : Type<ParentNullableEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(parentData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ParentNullableEntity {
      val builder = builder()
      builder.parentData = parentData
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion

}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: ParentNullableEntity, modification: ParentNullableEntity.Builder.() -> Unit) = modifyEntity(
  ParentNullableEntity.Builder::class.java, entity, modification)
//endregion

interface ChildNullableEntity : WorkspaceEntity {
  val childData: String

  val parentEntity: ParentNullableEntity

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ChildNullableEntity, WorkspaceEntity.Builder<ChildNullableEntity>, ObjBuilder<ChildNullableEntity> {
    override var entitySource: EntitySource
    override var childData: String
    override var parentEntity: ParentNullableEntity
  }

  companion object : Type<ChildNullableEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(childData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ChildNullableEntity {
      val builder = builder()
      builder.childData = childData
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion

}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: ChildNullableEntity, modification: ChildNullableEntity.Builder.() -> Unit) = modifyEntity(
  ChildNullableEntity.Builder::class.java, entity, modification)
//endregion
