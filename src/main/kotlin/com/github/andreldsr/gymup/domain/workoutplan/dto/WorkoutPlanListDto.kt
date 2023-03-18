package com.github.andreldsr.gymup.domain.workoutplan.dto

import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import java.util.UUID

data class WorkoutPlanListDto(
    val name: String,
    val identifier: UUID
)

fun WorkoutPlan.toListDto() = WorkoutPlanListDto(
    name, identifier
)