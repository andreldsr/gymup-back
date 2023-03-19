package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.user.dto.UserDetailDto
import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import com.github.andreldsr.gymup.domain.user.form.toModel
import com.github.andreldsr.gymup.gateway.user.UserGateway
import com.github.andreldsr.gymup.service.UserService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(private val userGateway: UserGateway) : UserService {
    override fun create(userCreateForm: UserCreateForm): UserDetailDto {
        return userGateway.create(userCreateForm.toModel())
    }

    override fun delete(identifier: UUID) {
        userGateway.delete(identifier)
    }

    override fun findByIdentifier(identifier: UUID): UserDetailDto {
        return userGateway.findDetailByIdentifier(identifier)
    }

    override fun findByEmail(email: String): UserDetailDto {
        return userGateway.findByEmail(email)
    }
}
