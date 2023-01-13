package com.github.andreldsr.gymup.gateway.user

import com.github.andreldsr.gymup.domain.user.model.Role
import java.util.UUID

interface RoleGateway {
    fun create(role: Role): Role
    fun delete(identifier: UUID)
    fun findAll(): List<Role>
    fun findByName(name: String): Role
    fun findByUserIdentifier(identifier: UUID): List<Role>
}