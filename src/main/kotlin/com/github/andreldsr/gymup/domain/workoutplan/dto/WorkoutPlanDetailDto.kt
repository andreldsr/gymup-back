package com.github.andreldsr.gymup.domain.workoutplan.dto

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.dto.toListDto
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import java.util.UUID

data class WorkoutPlanDetailDto(
    val name: String,
    val identifier: UUID,
    val exercises: List<ExerciseListDto>
)

fun WorkoutPlan.toDetailDto() = WorkoutPlanDetailDto(
    name,
    identifier,
    exercises.map { it.toListDto() }
)
