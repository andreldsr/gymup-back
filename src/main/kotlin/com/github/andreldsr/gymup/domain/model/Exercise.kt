package com.github.andreldsr.gymup.domain.model

import java.util.UUID

data class Exercise(
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val group: MuscleGroup? = null
)
