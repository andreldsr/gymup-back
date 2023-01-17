package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.user.dto.UserDetailDto
import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import java.util.UUID

interface UserService {
    fun create(userCreateForm: UserCreateForm): UserDetailDto
    fun delete(identifier: UUID)
    fun findByIdentifier(identifier: UUID): UserDetailDto
    fun findByEmail(email: String): UserDetailDto
}
