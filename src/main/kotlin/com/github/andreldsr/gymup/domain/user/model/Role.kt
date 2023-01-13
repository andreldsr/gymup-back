package com.github.andreldsr.gymup.domain.user.model

import java.util.UUID

data class Role(
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String
)
