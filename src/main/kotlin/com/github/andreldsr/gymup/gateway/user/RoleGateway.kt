package com.github.andreldsr.gymup.gateway.user

import com.github.andreldsr.gymup.domain.user.dto.RoleListDto
import com.github.andreldsr.gymup.domain.user.form.RoleCreateForm
import java.util.UUID

interface RoleGateway {
    fun create(role: RoleCreateForm): RoleListDto
    fun delete(identifier: UUID)
    fun findAll(): List<RoleListDto>
    fun findByName(name: String): RoleListDto
    fun findByUserIdentifier(identifier: UUID): List<RoleListDto>
}
