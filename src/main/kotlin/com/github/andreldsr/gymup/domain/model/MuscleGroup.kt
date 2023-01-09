package com.github.andreldsr.gymup.domain.model

import java.util.UUID

data class MuscleGroup(
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String = ""
)
