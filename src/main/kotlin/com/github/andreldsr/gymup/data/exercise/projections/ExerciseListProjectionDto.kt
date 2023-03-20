package com.github.andreldsr.gymup.data.exercise.projections

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import java.util.UUID

interface ExerciseListProjectionDto {
    fun getIdentifier(): UUID
    fun getName(): String
}

fun ExerciseListProjectionDto.toDto() = ExerciseListDto(
    getIdentifier(),
    getName()
)
