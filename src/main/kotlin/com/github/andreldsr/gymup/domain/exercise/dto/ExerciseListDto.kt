package com.github.andreldsr.gymup.domain.exercise.dto

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import java.util.UUID

data class ExerciseListDto(
    val identifier: UUID,
    val name: String,
    val group: String
)

fun Exercise.toListDto() = ExerciseListDto(
    identifier,
    name,
    group?.name?:""
)
