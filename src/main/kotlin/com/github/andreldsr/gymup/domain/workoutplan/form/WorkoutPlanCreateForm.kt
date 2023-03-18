package com.github.andreldsr.gymup.domain.workoutplan.form

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import java.util.UUID

data class WorkoutPlanCreateForm(
    val name: String,
    val userIdentifier: UUID,
    val exercises: List<ExerciseListDto>
)

fun WorkoutPlanCreateForm.toModel() = WorkoutPlan(
    name = name,
    userIdentifier = userIdentifier
)