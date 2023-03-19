package com.github.andreldsr.gymup.data.user.entity

import com.github.andreldsr.gymup.domain.user.form.RoleCreateForm
import com.github.andreldsr.gymup.domain.user.form.toModel
import com.github.andreldsr.gymup.domain.user.model.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "role")
data class RoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String,
    @ManyToMany(fetch = FetchType.LAZY)
    var users: MutableSet<UserEntity> = mutableSetOf(),
    @CreatedDate
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at") @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RoleEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "id => $id || identifier => $identifier || name => $name"
    }
}

fun RoleEntity.toModel() = Role(id, identifier, name)

fun Role.toEntity() = RoleEntity(id, identifier, name)

fun RoleCreateForm.toEntity() = toModel().toEntity()
