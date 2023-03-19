package com.github.andreldsr.gymup.gateway.user

import com.github.andreldsr.gymup.domain.user.dto.RoleListDto
import com.github.andreldsr.gymup.domain.user.model.Role
import java.util.UUID

interface RoleGateway {
    fun create(role: Role): RoleListDto
    fun delete(identifier: UUID)
    fun findAll(): List<RoleListDto>
    fun findByName(name: String): RoleListDto
    fun findByUserIdentifier(identifier: UUID): List<RoleListDto>
}
