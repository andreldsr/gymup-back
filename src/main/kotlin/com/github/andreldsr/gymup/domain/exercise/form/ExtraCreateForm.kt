package com.github.andreldsr.gymup.domain.exercise.form

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import com.github.andreldsr.gymup.domain.exercise.model.Extra
import com.github.andreldsr.gymup.domain.exercise.model.ExtraType
import java.util.UUID

data class ExtraCreateForm(
    val description: String,
    val order: Int = 0,
    val exerciseIdentifier: UUID,
    val type: ExtraType
)

fun ExtraCreateForm.toModel() = Extra(
    description = description,
    order = order,
    exercise = Exercise(identifier = exerciseIdentifier, description = "", name = ""),
    type = type
)
