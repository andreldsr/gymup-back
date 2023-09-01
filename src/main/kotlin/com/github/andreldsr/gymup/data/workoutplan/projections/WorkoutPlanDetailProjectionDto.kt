package com.github.andreldsr.gymup.data.workoutplan.projections

import com.github.andreldsr.gymup.data.exercise.projections.ExerciseListProjectionDto
import com.github.andreldsr.gymup.data.exercise.projections.toDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanExerciseListDto
import java.util.UUID

interface WorkoutPlanDetailProjectionDto {
    fun getName(): String
    fun getIdentifier(): UUID
    fun getExercises(): List<WorkoutPlanExerciseProjectionListDto>
}
interface WorkoutPlanExerciseProjectionListDto{
    fun getExercise(): ExerciseListProjectionDto
    fun getRepetitions(): Int
    fun getSets(): Int
}

fun WorkoutPlanExerciseProjectionListDto.toDto() = WorkoutPlanExerciseListDto(
    exercise = getExercise().toDto(),
    sets = getSets(),
    repetitions = getRepetitions()
)
fun WorkoutPlanDetailProjectionDto.toDto() = WorkoutPlanDetailDto(
    getName(),
    getIdentifier(),
    getExercises().map { it.toDto() }
)
