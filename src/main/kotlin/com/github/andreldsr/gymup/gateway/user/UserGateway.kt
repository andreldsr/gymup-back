package com.github.andreldsr.gymup.gateway.user

import com.github.andreldsr.gymup.domain.user.dto.UserDetailDto
import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import com.github.andreldsr.gymup.domain.user.model.User
import java.util.UUID

interface UserGateway {
    fun create(user: UserCreateForm): UserDetailDto
    fun delete(identifier: UUID)
    fun findByIdentifier(identifier: UUID): User
    fun findDetailByIdentifier(identifier: UUID): UserDetailDto
    fun findByEmail(email: String): UserDetailDto
}
