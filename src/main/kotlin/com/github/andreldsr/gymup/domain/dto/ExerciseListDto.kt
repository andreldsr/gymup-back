package com.github.andreldsr.gymup.domain.dto

import com.github.andreldsr.gymup.domain.model.Exercise
import java.util.UUID

data class ExerciseListDto(
    val identifier: UUID,
    val name: String
)

fun Exercise.toListDto() = ExerciseListDto(
    identifier, name
)