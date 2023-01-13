package com.github.andreldsr.gymup.domain.user.dto

import com.github.andreldsr.gymup.domain.user.model.User
import java.util.UUID

data class UserListDto(
    val identifier: UUID,
    val name: String,
    val email: String
)

fun User.toListDto() = UserListDto(identifier, name, email)
