package com.github.andreldsr.gymup.data.user.repository

import com.github.andreldsr.gymup.data.user.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RoleRepository : JpaRepository<RoleEntity, Long> {
    fun findByUsers_Identifier(userIdentifier: UUID): List<RoleEntity>
    fun findByName(name: String): RoleEntity

    fun findByIdentifier(identifier: UUID): RoleEntity
}