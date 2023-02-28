package com.github.andreldsr.gymup.domain.workoutplan.model

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import java.util.UUID

data class WorkoutPlan(
    val id: Long,
    val identifier: UUID,
    val name: String,
    val userIdentifier: UUID,
    val active: Boolean,
    val exercises: List<Exercise>
)
