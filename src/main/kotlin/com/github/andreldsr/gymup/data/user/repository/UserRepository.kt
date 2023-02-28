package com.github.andreldsr.gymup.data.user.repository

import com.github.andreldsr.gymup.data.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity
    fun findByIdentifier(identifier: UUID): UserEntity
}
