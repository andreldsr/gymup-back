package com.github.andreldsr.gymup.data.workoutplan.projections

import com.github.andreldsr.gymup.data.exercise.projections.ExerciseListProjectionDto
import com.github.andreldsr.gymup.data.exercise.projections.toDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import java.util.UUID

interface WorkoutPlanDetailProjectionDto {
    fun getName(): String
    fun getIdentifier(): UUID
    fun getExercises(): List<ExerciseListProjectionDto>
}

fun WorkoutPlanDetailProjectionDto.toDto() = WorkoutPlanDetailDto(
    getName(),
    getIdentifier(),
    getExercises().map { it.toDto() }
)
