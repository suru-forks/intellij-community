// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.workspace.storage.testEntities.entities

import com.intellij.platform.workspace.storage.*
import com.intellij.platform.workspace.storage.WorkspaceEntity
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import com.intellij.platform.workspace.storage.ObjBuilder
import com.intellij.platform.workspace.storage.Type
import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion
import com.intellij.platform.workspace.storage.MutableEntityStorage




interface FirstEntityWithPId : WorkspaceEntityWithSymbolicId {
  val data: String
  override val symbolicId: FirstPId
    get() {
      return FirstPId(data)
    }

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : FirstEntityWithPId, WorkspaceEntity.Builder<FirstEntityWithPId>, ObjBuilder<FirstEntityWithPId> {
    override var entitySource: EntitySource
    override var data: String
  }

  companion object : Type<FirstEntityWithPId, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(data: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): FirstEntityWithPId {
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
fun MutableEntityStorage.modifyEntity(entity: FirstEntityWithPId, modification: FirstEntityWithPId.Builder.() -> Unit) = modifyEntity(
  FirstEntityWithPId.Builder::class.java, entity, modification)
//endregion

data class FirstPId(override val presentableName: String) : SymbolicEntityId<FirstEntityWithPId>

interface SecondEntityWithPId : WorkspaceEntityWithSymbolicId {
  val data: String
  override val symbolicId: SecondPId
    get() = SecondPId(data)

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : SecondEntityWithPId, WorkspaceEntity.Builder<SecondEntityWithPId>, ObjBuilder<SecondEntityWithPId> {
    override var entitySource: EntitySource
    override var data: String
  }

  companion object : Type<SecondEntityWithPId, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(data: String, entitySource: EntitySource, init: (Builder.() -> Unit)? = null): SecondEntityWithPId {
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
fun MutableEntityStorage.modifyEntity(entity: SecondEntityWithPId, modification: SecondEntityWithPId.Builder.() -> Unit) = modifyEntity(
  SecondEntityWithPId.Builder::class.java, entity, modification)
//endregion

data class SecondPId(override val presentableName: String) : SymbolicEntityId<SecondEntityWithPId>
data class TestPId(var presentableName: String, val aaa: Int?, var angry: Boolean)