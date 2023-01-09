package com.github.andreldsr.gymup.domain.dto

import com.github.andreldsr.gymup.domain.model.Exercise
import java.util.UUID

data class ExerciseDetailDto(
    val identifier: UUID,
    val name: String,
    val description: String,
    val muscleGroupName: String?
)

fun Exercise.toDetailDto() = ExerciseDetailDto(
    identifier = identifier,
    name = name,
    description = description,
    muscleGroupName = group?.name
)
