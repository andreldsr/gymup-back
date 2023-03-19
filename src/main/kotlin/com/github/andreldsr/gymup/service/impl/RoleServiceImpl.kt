package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.user.dto.RoleListDto
import com.github.andreldsr.gymup.domain.user.form.RoleCreateForm
import com.github.andreldsr.gymup.domain.user.form.toModel
import com.github.andreldsr.gymup.gateway.user.RoleGateway
import com.github.andreldsr.gymup.service.RoleService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RoleServiceImpl(private val roleGateway: RoleGateway) : RoleService {
    override fun create(roleCreateForm: RoleCreateForm): RoleListDto {
        return roleGateway.create(roleCreateForm.toModel())
    }

    override fun delete(identifier: UUID) {
        roleGateway.delete(identifier)
    }

    override fun findAll(): List<RoleListDto> {
        return roleGateway.findAll()
    }

    override fun findByName(name: String): RoleListDto {
        return roleGateway.findByName(name)
    }

    override fun findByUserIdentifier(identifier: UUID): List<RoleListDto> {
        return roleGateway.findByUserIdentifier(identifier)
    }
}
