package com.github.andreldsr.gymup.domain.form

import com.github.andreldsr.gymup.domain.model.Exercise
import com.github.andreldsr.gymup.domain.model.MuscleGroup
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