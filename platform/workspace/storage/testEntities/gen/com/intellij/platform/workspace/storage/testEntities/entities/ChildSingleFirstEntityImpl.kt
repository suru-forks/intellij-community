// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.workspace.storage.testEntities.entities

import com.intellij.platform.workspace.storage.EntityInformation
import com.intellij.platform.workspace.storage.EntitySource
import com.intellij.platform.workspace.storage.EntityStorage
import com.intellij.platform.workspace.storage.GeneratedCodeApiVersion
import com.intellij.platform.workspace.storage.GeneratedCodeImplVersion
import com.intellij.platform.workspace.storage.MutableEntityStorage
import com.intellij.platform.workspace.storage.WorkspaceEntity
import com.intellij.platform.workspace.storage.impl.ConnectionId
import com.intellij.platform.workspace.storage.impl.EntityLink
import com.intellij.platform.workspace.storage.impl.ModifiableWorkspaceEntityBase
import com.intellij.platform.workspace.storage.impl.UsedClassesCollector
import com.intellij.platform.workspace.storage.impl.WorkspaceEntityBase
import com.intellij.platform.workspace.storage.impl.WorkspaceEntityData
import com.intellij.platform.workspace.storage.impl.extractOneToAbstractOneParent
import com.intellij.platform.workspace.storage.impl.updateOneToAbstractOneParentOfChild

@GeneratedCodeApiVersion(1)
@GeneratedCodeImplVersion(1)
open class ChildSingleFirstEntityImpl(val dataSource: ChildSingleFirstEntityData) : ChildSingleFirstEntity, WorkspaceEntityBase() {

  companion object {
    internal val PARENTENTITY_CONNECTION_ID: ConnectionId = ConnectionId.create(ParentSingleAbEntity::class.java,
                                                                                ChildSingleAbstractBaseEntity::class.java,
                                                                                ConnectionId.ConnectionType.ABSTRACT_ONE_TO_ONE, false)

    val connections = listOf<ConnectionId>(
      PARENTENTITY_CONNECTION_ID,
    )

  }

  override val commonData: String
    get() = dataSource.commonData

  override val parentEntity: ParentSingleAbEntity
    get() = snapshot.extractOneToAbstractOneParent(PARENTENTITY_CONNECTION_ID, this)!!

  override val firstData: String
    get() = dataSource.firstData

  override val entitySource: EntitySource
    get() = dataSource.entitySource

  override fun connectionIdList(): List<ConnectionId> {
    return connections
  }

  class Builder(result: ChildSingleFirstEntityData?) : ModifiableWorkspaceEntityBase<ChildSingleFirstEntity, ChildSingleFirstEntityData>(
    result), ChildSingleFirstEntity.Builder {
    constructor() : this(ChildSingleFirstEntityData())

    override fun applyToBuilder(builder: MutableEntityStorage) {
      if (this.diff != null) {
        if (existsInBuilder(builder)) {
          this.diff = builder
          return
        }
        else {
          error("Entity ChildSingleFirstEntity is already created in a different builder")
        }
      }

      this.diff = builder
      this.snapshot = builder
      addToBuilder()
      this.id = getEntityData().createEntityId()
      // After adding entity data to the builder, we need to unbind it and move the control over entity data to builder
      // Builder may switch to snapshot at any moment and lock entity data to modification
      this.currentEntityData = null

      // Process linked entities that are connected without a builder
      processLinkedEntities(builder)
      checkInitialization() // TODO uncomment and check failed tests
    }

    fun checkInitialization() {
      val _diff = diff
      if (!getEntityData().isEntitySourceInitialized()) {
        error("Field WorkspaceEntity#entitySource should be initialized")
      }
      if (!getEntityData().isCommonDataInitialized()) {
        error("Field ChildSingleAbstractBaseEntity#commonData should be initialized")
      }
      if (_diff != null) {
        if (_diff.extractOneToAbstractOneParent<WorkspaceEntityBase>(PARENTENTITY_CONNECTION_ID, this) == null) {
          error("Field ChildSingleAbstractBaseEntity#parentEntity should be initialized")
        }
      }
      else {
        if (this.entityLinks[EntityLink(false, PARENTENTITY_CONNECTION_ID)] == null) {
          error("Field ChildSingleAbstractBaseEntity#parentEntity should be initialized")
        }
      }
      if (!getEntityData().isFirstDataInitialized()) {
        error("Field ChildSingleFirstEntity#firstData should be initialized")
      }
    }

    override fun connectionIdList(): List<ConnectionId> {
      return connections
    }

    // Relabeling code, move information from dataSource to this builder
    override fun relabel(dataSource: WorkspaceEntity, parents: Set<WorkspaceEntity>?) {
      dataSource as ChildSingleFirstEntity
      if (this.entitySource != dataSource.entitySource) this.entitySource = dataSource.entitySource
      if (this.commonData != dataSource.commonData) this.commonData = dataSource.commonData
      if (this.firstData != dataSource.firstData) this.firstData = dataSource.firstData
      updateChildToParentReferences(parents)
    }


    override var entitySource: EntitySource
      get() = getEntityData().entitySource
      set(value) {
        checkModificationAllowed()
        getEntityData(true).entitySource = value
        changedProperty.add("entitySource")

      }

    override var commonData: String
      get() = getEntityData().commonData
      set(value) {
        checkModificationAllowed()
        getEntityData(true).commonData = value
        changedProperty.add("commonData")
      }

    override var parentEntity: ParentSingleAbEntity
      get() {
        val _diff = diff
        return if (_diff != null) {
          _diff.extractOneToAbstractOneParent(PARENTENTITY_CONNECTION_ID, this) ?: this.entityLinks[EntityLink(false,
                                                                                                               PARENTENTITY_CONNECTION_ID)]!! as ParentSingleAbEntity
        }
        else {
          this.entityLinks[EntityLink(false, PARENTENTITY_CONNECTION_ID)]!! as ParentSingleAbEntity
        }
      }
      set(value) {
        checkModificationAllowed()
        val _diff = diff
        if (_diff != null && value is ModifiableWorkspaceEntityBase<*, *> && value.diff == null) {
          if (value is ModifiableWorkspaceEntityBase<*, *>) {
            value.entityLinks[EntityLink(true, PARENTENTITY_CONNECTION_ID)] = this
          }
          // else you're attaching a new entity to an existing entity that is not modifiable
          _diff.addEntity(value)
        }
        if (_diff != null && (value !is ModifiableWorkspaceEntityBase<*, *> || value.diff != null)) {
          _diff.updateOneToAbstractOneParentOfChild(PARENTENTITY_CONNECTION_ID, this, value)
        }
        else {
          if (value is ModifiableWorkspaceEntityBase<*, *>) {
            value.entityLinks[EntityLink(true, PARENTENTITY_CONNECTION_ID)] = this
          }
          // else you're attaching a new entity to an existing entity that is not modifiable

          this.entityLinks[EntityLink(false, PARENTENTITY_CONNECTION_ID)] = value
        }
        changedProperty.add("parentEntity")
      }

    override var firstData: String
      get() = getEntityData().firstData
      set(value) {
        checkModificationAllowed()
        getEntityData(true).firstData = value
        changedProperty.add("firstData")
      }

    override fun getEntityClass(): Class<ChildSingleFirstEntity> = ChildSingleFirstEntity::class.java
  }
}

class ChildSingleFirstEntityData : WorkspaceEntityData<ChildSingleFirstEntity>() {
  lateinit var commonData: String
  lateinit var firstData: String

  fun isCommonDataInitialized(): Boolean = ::commonData.isInitialized
  fun isFirstDataInitialized(): Boolean = ::firstData.isInitialized

  override fun wrapAsModifiable(diff: MutableEntityStorage): WorkspaceEntity.Builder<ChildSingleFirstEntity> {
    val modifiable = ChildSingleFirstEntityImpl.Builder(null)
    modifiable.diff = diff
    modifiable.snapshot = diff
    modifiable.id = createEntityId()
    return modifiable
  }

  override fun createEntity(snapshot: EntityStorage): ChildSingleFirstEntity {
    return getCached(snapshot) {
      val entity = ChildSingleFirstEntityImpl(this)
      entity.snapshot = snapshot
      entity.id = createEntityId()
      entity
    }
  }

  override fun getEntityInterface(): Class<out WorkspaceEntity> {
    return ChildSingleFirstEntity::class.java
  }

  override fun serialize(ser: EntityInformation.Serializer) {
  }

  override fun deserialize(de: EntityInformation.Deserializer) {
  }

  override fun createDetachedEntity(parents: List<WorkspaceEntity>): WorkspaceEntity {
    return ChildSingleFirstEntity(commonData, firstData, entitySource) {
      parents.filterIsInstance<ParentSingleAbEntity>().singleOrNull()?.let { this.parentEntity = it }
    }
  }

  override fun getRequiredParents(): List<Class<out WorkspaceEntity>> {
    val res = mutableListOf<Class<out WorkspaceEntity>>()
    res.add(ParentSingleAbEntity::class.java)
    return res
  }

  override fun equals(other: Any?): Boolean {
    if (other == null) return false
    if (this.javaClass != other.javaClass) return false

    other as ChildSingleFirstEntityData

    if (this.entitySource != other.entitySource) return false
    if (this.commonData != other.commonData) return false
    if (this.firstData != other.firstData) return false
    return true
  }

  override fun equalsIgnoringEntitySource(other: Any?): Boolean {
    if (other == null) return false
    if (this.javaClass != other.javaClass) return false

    other as ChildSingleFirstEntityData

    if (this.commonData != other.commonData) return false
    if (this.firstData != other.firstData) return false
    return true
  }

  override fun hashCode(): Int {
    var result = entitySource.hashCode()
    result = 31 * result + commonData.hashCode()
    result = 31 * result + firstData.hashCode()
    return result
  }

  override fun hashCodeIgnoringEntitySource(): Int {
    var result = javaClass.hashCode()
    result = 31 * result + commonData.hashCode()
    result = 31 * result + firstData.hashCode()
    return result
  }

  override fun collectClassUsagesData(collector: UsedClassesCollector) {
    collector.sameForAllEntities = true
  }
}
