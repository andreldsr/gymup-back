package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.user.dto.RoleListDto
import com.github.andreldsr.gymup.domain.user.form.RoleCreateForm
import java.util.UUID

interface RoleService {
    fun create(roleCreateForm: RoleCreateForm): RoleListDto
    fun delete(identifier: UUID)
    fun findAll(): List<RoleListDto>
    fun findByName(name: String): RoleListDto
    fun findByUserIdentifier(identifier: UUID): List<RoleListDto>
}
