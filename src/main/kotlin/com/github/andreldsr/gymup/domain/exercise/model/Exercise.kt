package com.github.andreldsr.gymup.domain.exercise.model

import com.github.andreldsr.gymup.domain.musclegroup.model.MuscleGroup
import java.util.UUID

data class Exercise(
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String,
    val description: String,
    val group: MuscleGroup? = null
)
