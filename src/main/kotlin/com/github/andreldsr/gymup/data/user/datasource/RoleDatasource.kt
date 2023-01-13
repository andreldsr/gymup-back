package com.github.andreldsr.gymup.data.user.datasource

import com.github.andreldsr.gymup.data.user.entity.toEntity
import com.github.andreldsr.gymup.data.user.entity.toModel
import com.github.andreldsr.gymup.data.user.repository.RoleRepository
import com.github.andreldsr.gymup.domain.user.model.Role
import com.github.andreldsr.gymup.gateway.user.RoleGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class RoleDatasource(private val roleRepository: RoleRepository) : RoleGateway {
    override fun create(role: Role): Role {
        return roleRepository.save(role.toEntity()).toModel()
    }

    override fun delete(identifier: UUID) {
        roleRepository.delete(roleRepository.findByIdentifier(identifier))
    }

    override fun findAll(): List<Role> {
        return roleRepository.findAll().map { it.toModel() }
    }

    override fun findByName(name: String): Role {
        return roleRepository.findByName(name).toModel()
    }

    override fun findByUserIdentifier(identifier: UUID): List<Role> {
        return roleRepository.findByUsers_Identifier(identifier).map { it.toModel() }
    }
}