package com.github.andreldsr.gymup.domain.user.dto

import com.github.andreldsr.gymup.domain.user.model.Role
import java.util.UUID

data class RoleListDto(
    val identifier: UUID,
    val name: String,
)

fun Role.toListDto() = RoleListDto(identifier, name)