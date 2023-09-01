package com.github.andreldsr.gymup.domain.workoutplan.dto

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.dto.toListDto
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import java.util.UUID

data class WorkoutPlanDetailDto(
    val name: String,
    val identifier: UUID,
    val exercises: List<WorkoutPlanExerciseListDto>
)

data class WorkoutPlanExerciseListDto(
    val exercise: ExerciseListDto,
    val sets: Int,
    val repetitions: Int
)

//fun WorkoutPlanExerciseListDto.toDto() = W
fun WorkoutPlan.toDetailDto() = WorkoutPlanDetailDto(
    name,
    identifier,
    exercises.map { WorkoutPlanExerciseListDto(it.exercise.toListDto(), it.sets, it.repetitions) }
)
