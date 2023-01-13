package com.github.andreldsr.gymup.data.user.datasource

import com.github.andreldsr.gymup.data.user.entity.toEntity
import com.github.andreldsr.gymup.data.user.entity.toModel
import com.github.andreldsr.gymup.data.user.repository.UserRepository
import com.github.andreldsr.gymup.domain.user.model.User
import com.github.andreldsr.gymup.gateway.user.UserGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserDatasource(private val userRepository: UserRepository) : UserGateway {
    override fun create(user: User): User {
        return userRepository.save(user.toEntity()).toModel()
    }

    override fun delete(identifier: UUID) {
        userRepository.delete(userRepository.findByIdentifier(identifier))
    }

    override fun findByIdentifier(identifier: UUID): User {
        return userRepository.findByIdentifier(identifier).toModel()
    }

    override fun findByEmail(email: String): User {
        return userRepository.findByEmail(email).toModel()
    }
}