package com.github.andreldsr.gymup.domain.user.dto

import com.github.andreldsr.gymup.domain.user.model.User
import java.util.UUID

data class UserDetailDto(
    val identifier: UUID,
    val name: String,
    val email: String,
    var roles: List<RoleListDto> = emptyList()
)

fun User.toDetailDto() = UserDetailDto(identifier, name, email)
