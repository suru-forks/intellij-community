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



interface ParentMultipleEntity : WorkspaceEntity {
  val parentData: String
  val children: List<@Child ChildMultipleEntity>

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ParentMultipleEntity, WorkspaceEntity.Builder<ParentMultipleEntity>, ObjBuilder<ParentMultipleEntity> {
    override var entitySource: EntitySource
    override var parentData: String
    override var children: List<ChildMultipleEntity>
  }

  companion object : Type<ParentMultipleEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(parentData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ParentMultipleEntity {
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
fun MutableEntityStorage.modifyEntity(entity: ParentMultipleEntity, modification: ParentMultipleEntity.Builder.() -> Unit) = modifyEntity(
  ParentMultipleEntity.Builder::class.java, entity, modification)
//endregion

interface ChildMultipleEntity : WorkspaceEntity {
  val childData: String

  val parentEntity: ParentMultipleEntity

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ChildMultipleEntity, WorkspaceEntity.Builder<ChildMultipleEntity>, ObjBuilder<ChildMultipleEntity> {
    override var entitySource: EntitySource
    override var childData: String
    override var parentEntity: ParentMultipleEntity
  }

  companion object : Type<ChildMultipleEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(childData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ChildMultipleEntity {
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
fun MutableEntityStorage.modifyEntity(entity: ChildMultipleEntity, modification: ChildMultipleEntity.Builder.() -> Unit) = modifyEntity(
  ChildMultipleEntity.Builder::class.java, entity, modification)
//endregion
