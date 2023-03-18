package com.github.andreldsr.gymup.data.user.datasource

import com.github.andreldsr.gymup.data.user.entity.toEntity
import com.github.andreldsr.gymup.data.user.entity.toModel
import com.github.andreldsr.gymup.data.user.repository.RoleRepository
import com.github.andreldsr.gymup.domain.user.dto.RoleListDto
import com.github.andreldsr.gymup.domain.user.dto.toListDto
import com.github.andreldsr.gymup.domain.user.form.RoleCreateForm
import com.github.andreldsr.gymup.gateway.user.RoleGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class RoleDatasource(private val roleRepository: RoleRepository) : RoleGateway {
    override fun create(role: RoleCreateForm): RoleListDto {
        return roleRepository.save(role.toEntity()).toModel().toListDto()
    }

    override fun delete(identifier: UUID) {
        roleRepository.delete(roleRepository.findByIdentifier(identifier))
    }

    override fun findAll(): List<RoleListDto> {
        return roleRepository.findAll().map { it.toModel().toListDto() }
    }

    override fun findByName(name: String): RoleListDto {
        return roleRepository.findByName(name).toModel().toListDto()
    }

    override fun findByUserIdentifier(identifier: UUID): List<RoleListDto> {
        return roleRepository.findByUsers_Identifier(identifier).map { it.toModel().toListDto() }
    }
}
