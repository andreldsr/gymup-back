package com.github.andreldsr.gymup.data.user.datasource

import com.github.andreldsr.gymup.data.user.entity.toEntity
import com.github.andreldsr.gymup.data.user.entity.toModel
import com.github.andreldsr.gymup.data.user.repository.UserRepository
import com.github.andreldsr.gymup.domain.user.dto.UserDetailDto
import com.github.andreldsr.gymup.domain.user.dto.toDetailDto
import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import com.github.andreldsr.gymup.domain.user.model.User
import com.github.andreldsr.gymup.gateway.user.UserGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserDatasource(private val userRepository: UserRepository) : UserGateway {
    override fun create(user: UserCreateForm): UserDetailDto {
        return userRepository.save(user.toEntity()).toModel().toDetailDto()
    }

    override fun delete(identifier: UUID) {
        userRepository.delete(userRepository.findByIdentifier(identifier))
    }

    override fun findByIdentifier(identifier: UUID): User {
        return userRepository.findByIdentifier(identifier).toModel()
    }
    override fun findDetailByIdentifier(identifier: UUID): UserDetailDto {
        return userRepository.findByIdentifier(identifier).toModel().toDetailDto()
    }

    override fun findByEmail(email: String): UserDetailDto {
        return userRepository.findByEmail(email).toModel().toDetailDto()
    }
}
