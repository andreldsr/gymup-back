package com.github.andreldsr.gymup.data.user.entity

import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import com.github.andreldsr.gymup.domain.user.form.toModel
import com.github.andreldsr.gymup.domain.user.model.User
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
@Table(name = "\"user\"")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String = "",
    @Column(unique = true)
    val email: String = "",
    val password: String = "",
    @ManyToMany(fetch = FetchType.LAZY)
    var roles: MutableSet<RoleEntity> = mutableSetOf(),
    @CreatedDate
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    fun addRole(role: RoleEntity) {
        this.roles.add(role)
        role.users.add(this)
    }
}

fun UserEntity.toModel() = User(id, identifier, name, email, password)
fun User.toEntity() = UserEntity(id, identifier, name, email, password)
fun UserCreateForm.toEntity() = toModel().toEntity()
