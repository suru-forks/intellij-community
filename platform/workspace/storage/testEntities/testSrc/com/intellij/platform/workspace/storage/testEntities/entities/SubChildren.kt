// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.workspace.storage.testEntities.entities

import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion

import com.intellij.platform.workspace.storage.MutableEntityStorage
import com.intellij.platform.workspace.storage.WorkspaceEntity
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import com.intellij.platform.workspace.storage.ObjBuilder
import com.intellij.platform.workspace.storage.Type
import com.intellij.platform.workspace.storage.annotations.Child



interface ParentSubEntity : WorkspaceEntity {
  val parentData: String

  @Child
  val child: ChildSubEntity?

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ParentSubEntity, WorkspaceEntity.Builder<ParentSubEntity>, ObjBuilder<ParentSubEntity> {
    override var entitySource: EntitySource
    override var parentData: String
    override var child: ChildSubEntity?
  }

  companion object : Type<ParentSubEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(parentData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ParentSubEntity {
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
fun MutableEntityStorage.modifyEntity(entity: ParentSubEntity, modification: ParentSubEntity.Builder.() -> Unit) = modifyEntity(
  ParentSubEntity.Builder::class.java, entity, modification)
//endregion

interface ChildSubEntity : WorkspaceEntity {
  val parentEntity: ParentSubEntity

  @Child
  val child: ChildSubSubEntity?

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ChildSubEntity, WorkspaceEntity.Builder<ChildSubEntity>, ObjBuilder<ChildSubEntity> {
    override var entitySource: EntitySource
    override var parentEntity: ParentSubEntity
    override var child: ChildSubSubEntity?
  }

  companion object : Type<ChildSubEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ChildSubEntity {
      val builder = builder()
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion

}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: ChildSubEntity, modification: ChildSubEntity.Builder.() -> Unit) = modifyEntity(
  ChildSubEntity.Builder::class.java, entity, modification)
//endregion

interface ChildSubSubEntity : WorkspaceEntity {
  val parentEntity: ChildSubEntity

  val childData: String

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ChildSubSubEntity, WorkspaceEntity.Builder<ChildSubSubEntity>, ObjBuilder<ChildSubSubEntity> {
    override var entitySource: EntitySource
    override var parentEntity: ChildSubEntity
    override var childData: String
  }

  companion object : Type<ChildSubSubEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(childData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ChildSubSubEntity {
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
fun MutableEntityStorage.modifyEntity(entity: ChildSubSubEntity, modification: ChildSubSubEntity.Builder.() -> Unit) = modifyEntity(
  ChildSubSubEntity.Builder::class.java, entity, modification)
//endregion
