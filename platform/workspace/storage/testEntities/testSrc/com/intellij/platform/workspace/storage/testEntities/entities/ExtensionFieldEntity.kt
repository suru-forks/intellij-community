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



interface MainEntity : WorkspaceEntity {
  val x: String

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : MainEntity, WorkspaceEntity.Builder<MainEntity>, ObjBuilder<MainEntity> {
    override var entitySource: EntitySource
    override var x: String
  }

  companion object : Type<MainEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(x: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): MainEntity {
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
fun MutableEntityStorage.modifyEntity(entity: MainEntity, modification: MainEntity.Builder.() -> Unit) = modifyEntity(
  MainEntity.Builder::class.java, entity, modification)

var MainEntity.Builder.child: @Child AttachedEntity?
  by WorkspaceEntity.extension()
//endregion

interface AttachedEntity : WorkspaceEntity {
  val ref: MainEntity
  val data: String

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : AttachedEntity, WorkspaceEntity.Builder<AttachedEntity>, ObjBuilder<AttachedEntity> {
    override var entitySource: EntitySource
    override var ref: MainEntity
    override var data: String
  }

  companion object : Type<AttachedEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(data: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): AttachedEntity {
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
fun MutableEntityStorage.modifyEntity(entity: AttachedEntity, modification: AttachedEntity.Builder.() -> Unit) = modifyEntity(
  AttachedEntity.Builder::class.java, entity, modification)
//endregion

val MainEntity.child: @Child AttachedEntity?
    by WorkspaceEntity.extension()
