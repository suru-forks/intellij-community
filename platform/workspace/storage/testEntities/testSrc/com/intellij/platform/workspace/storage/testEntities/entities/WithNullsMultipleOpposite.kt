// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.workspace.storage.testEntities.entities

import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion
import com.intellij.platform.workspace.storage.MutableEntityStorage
import com.intellij.platform.workspace.storage.WorkspaceEntity
import com.intellij.platform.workspace.storage.ObjBuilder
import com.intellij.platform.workspace.storage.Type
import com.intellij.platform.workspace.storage.annotations.Child



interface ParentWithNullsOppositeMultiple : WorkspaceEntity {
  val parentData: String

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ParentWithNullsOppositeMultiple, WorkspaceEntity.Builder<ParentWithNullsOppositeMultiple>, ObjBuilder<ParentWithNullsOppositeMultiple> {
    override var entitySource: EntitySource
    override var parentData: String
  }

  companion object : Type<ParentWithNullsOppositeMultiple, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(parentData: String,
                        entitySource: EntitySource,
                        init: (Builder.() -> Unit)? = null): ParentWithNullsOppositeMultiple {
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
fun MutableEntityStorage.modifyEntity(entity: ParentWithNullsOppositeMultiple,
                                      modification: ParentWithNullsOppositeMultiple.Builder.() -> Unit) = modifyEntity(
  ParentWithNullsOppositeMultiple.Builder::class.java, entity, modification)

var ParentWithNullsOppositeMultiple.Builder.children: @Child List<ChildWithNullsOppositeMultiple>
  by WorkspaceEntity.extension()
//endregion


interface ChildWithNullsOppositeMultiple : WorkspaceEntity {
  val childData: String

  val parentEntity: ParentWithNullsOppositeMultiple?

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : ChildWithNullsOppositeMultiple, WorkspaceEntity.Builder<ChildWithNullsOppositeMultiple>, ObjBuilder<ChildWithNullsOppositeMultiple> {
    override var entitySource: EntitySource
    override var childData: String
    override var parentEntity: ParentWithNullsOppositeMultiple?
  }

  companion object : Type<ChildWithNullsOppositeMultiple, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(childData: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): ChildWithNullsOppositeMultiple {
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
fun MutableEntityStorage.modifyEntity(entity: ChildWithNullsOppositeMultiple,
                                      modification: ChildWithNullsOppositeMultiple.Builder.() -> Unit) = modifyEntity(
  ChildWithNullsOppositeMultiple.Builder::class.java, entity, modification)
//endregion


val ParentWithNullsOppositeMultiple.children: List<@Child ChildWithNullsOppositeMultiple>
    by WorkspaceEntity.extension()
