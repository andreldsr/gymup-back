package com.github.andreldsr.gymup.domain.workoutplan.model

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import java.util.UUID

data class WorkoutPlan(
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val name: String,
    val userIdentifier: UUID,
    val active: Boolean = true,
    val exercises: List<Exercise> = listOf()
)
