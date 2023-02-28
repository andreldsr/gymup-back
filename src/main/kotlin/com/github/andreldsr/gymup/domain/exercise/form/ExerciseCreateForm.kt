package com.github.andreldsr.gymup.domain.exercise.form

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import com.github.andreldsr.gymup.domain.musclegroup.model.MuscleGroup
import java.util.UUID

data class ExerciseCreateForm(
    val name: String,
    val description: String,
    val muscleGroupIdentifier: UUID
)

fun ExerciseCreateForm.toModel() = Exercise(
    name = name,
    description = description,
    group = MuscleGroup(identifier = muscleGroupIdentifier)
)
