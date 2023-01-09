package com.github.andreldsr.gymup.domain.exercise.dto

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import java.util.UUID

data class ExerciseDetailDto(
    val identifier: UUID,
    val name: String,
    val description: String,
    val muscleGroupName: String?,
    var extras: Map<String, List<ExtraListDto>> = emptyMap()
)

fun Exercise.toDetailDto() = ExerciseDetailDto(
    identifier = identifier,
    name = name,
    description = description,
    muscleGroupName = group?.name
)
