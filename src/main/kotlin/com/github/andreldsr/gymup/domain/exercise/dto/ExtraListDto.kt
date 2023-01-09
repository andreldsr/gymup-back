package com.github.andreldsr.gymup.domain.exercise.dto

import com.github.andreldsr.gymup.domain.exercise.model.Extra
import com.github.andreldsr.gymup.domain.exercise.model.ExtraType

data class ExtraListDto(
    val description: String,
    val order: Int,
    val exerciseName: String,
    val type: ExtraType
)

fun Extra.toListDto() = ExtraListDto(
    description, order, exercise.name, type
)
