// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.workspace.storage.testEntities.entities

import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import com.intellij.platform.workspace.storage.ObjBuilder
import com.intellij.platform.workspace.storage.Type
import com.intellij.platform.workspace.storage.annotations.Child
import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion
import com.intellij.platform.workspace.storage.MutableEntityStorage
import com.intellij.platform.workspace.storage.WorkspaceEntity



interface MainEntityToParent : WorkspaceEntity {
  val x: String
  val child: @Child AttachedEntityToParent?
  val childNullableParent: @Child AttachedEntityToNullableParent?

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : MainEntityToParent, WorkspaceEntity.Builder<MainEntityToParent>, ObjBuilder<MainEntityToParent> {
    override var entitySource: EntitySource
    override var x: String
    override var child: AttachedEntityToParent?
    override var childNullableParent: AttachedEntityToNullableParent?
  }

  companion object : Type<MainEntityToParent, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(x: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): MainEntityToParent {
      val builder = builder()
      builder.x = x
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion

}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: MainEntityToParent, modification: MainEntityToParent.Builder.() -> Unit) = modifyEntity(
  MainEntityToParent.Builder::class.java, entity, modification)
//endregion

interface AttachedEntityToParent : WorkspaceEntity {
  val data: String

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : AttachedEntityToParent, WorkspaceEntity.Builder<AttachedEntityToParent>, ObjBuilder<AttachedEntityToParent> {
    override var entitySource: EntitySource
    override var data: String
  }

  companion object : Type<AttachedEntityToParent, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(data: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): AttachedEntityToParent {
      val builder = builder()
      builder.data = data
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion

}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: AttachedEntityToParent,
                                      modification: AttachedEntityToParent.Builder.() -> Unit) = modifyEntity(
  AttachedEntityToParent.Builder::class.java, entity, modification)

var AttachedEntityToParent.Builder.ref: MainEntityToParent
  by WorkspaceEntity.extension()
//endregion

val AttachedEntityToParent.ref: MainEntityToParent
    by WorkspaceEntity.extension()


interface AttachedEntityToNullableParent: WorkspaceEntity {
  val data: String

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : AttachedEntityToNullableParent, WorkspaceEntity.Builder<AttachedEntityToNullableParent>, ObjBuilder<AttachedEntityToNullableParent> {
    override var entitySource: EntitySource
    override var data: String
  }

  companion object : Type<AttachedEntityToNullableParent, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(data: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): AttachedEntityToNullableParent {
      val builder = builder()
      builder.data = data
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion
}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: AttachedEntityToNullableParent,
                                      modification: AttachedEntityToNullableParent.Builder.() -> Unit) = modifyEntity(
  AttachedEntityToNullableParent.Builder::class.java, entity, modification)

var AttachedEntityToNullableParent.Builder.nullableRef: MainEntityToParent?
  by WorkspaceEntity.extension()
//endregion

val AttachedEntityToNullableParent.nullableRef: MainEntityToParent?
  by WorkspaceEntity.extension()