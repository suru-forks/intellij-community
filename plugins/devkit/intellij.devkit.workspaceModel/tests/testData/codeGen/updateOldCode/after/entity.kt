//new comment
package com.intellij.workspaceModel.test.api

import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion
import com.intellij.platform.workspace.storage.MutableEntityStorage
import com.intellij.platform.workspace.storage.WorkspaceEntity
import com.intellij.platform.workspace.storage.ObjBuilder
import com.intellij.platform.workspace.storage.Type

interface SimpleEntity : WorkspaceEntity {
  val version: Int
  val name: String
  val isSimple: Boolean

  //region generated code
  @GeneratedCodeApiVersion(1)
  interface Builder : SimpleEntity, WorkspaceEntity.Builder<SimpleEntity>, ObjBuilder<SimpleEntity> {
    override var entitySource: EntitySource
    override var version: Int
    override var name: String
    override var isSimple: Boolean
  }

  companion object : Type<SimpleEntity, Builder>() {
    @JvmOverloads
    @JvmStatic
    @JvmName("create")
    operator fun invoke(version: Int,
                        name: String,
                        isSimple: Boolean,
                        entitySource: EntitySource,
                        init: (Builder.() -> Unit)? = null): SimpleEntity {
      val builder = builder()
      builder.version = version
      builder.name = name
      builder.isSimple = isSimple
      builder.entitySource = entitySource
      init?.invoke(builder)
      return builder
    }
  }
  //endregion
}

//region generated code
fun MutableEntityStorage.modifyEntity(entity: SimpleEntity, modification: SimpleEntity.Builder.() -> Unit) = modifyEntity(
  SimpleEntity.Builder::class.java, entity, modification)
//endregion
