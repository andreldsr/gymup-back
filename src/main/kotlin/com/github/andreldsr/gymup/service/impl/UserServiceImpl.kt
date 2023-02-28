package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.user.dto.UserDetailDto
import com.github.andreldsr.gymup.domain.user.dto.toDetailDto
import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import com.github.andreldsr.gymup.domain.user.form.toModel
import com.github.andreldsr.gymup.gateway.user.UserGateway
import com.github.andreldsr.gymup.service.UserService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(private val userGateway: UserGateway) : UserService {
    override fun create(userCreateForm: UserCreateForm): UserDetailDto {
        return userGateway.create(userCreateForm.toModel()).toDetailDto()
    }

    override fun delete(identifier: UUID) {
        userGateway.delete(identifier)
    }

    override fun findByIdentifier(identifier: UUID): UserDetailDto {
        return userGateway.findByIdentifier(identifier).toDetailDto()
    }

    override fun findByEmail(email: String): UserDetailDto {
        return userGateway.findByEmail(email).toDetailDto()
    }
}
