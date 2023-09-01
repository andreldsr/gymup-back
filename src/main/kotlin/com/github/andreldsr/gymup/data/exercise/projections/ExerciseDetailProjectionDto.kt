package com.github.andreldsr.gymup.data.exercise.projections

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseDetailDto
import java.util.UUID

interface ExerciseDetailProjectionDto {
    fun getIdentifier(): UUID
    fun getName(): String
    fun getDescription(): String
    fun getGroup(): ExerciseGroupProjectionDto
    fun getExtras(): List<ExtraListProjectionDto>
}

interface ExerciseGroupProjectionDto{
    fun getName(): String
}

fun ExerciseDetailProjectionDto.toDto() = ExerciseDetailDto(
    getIdentifier(),
    getName(),
    getDescription(),
    getGroup().getName(),
    getExtras().map { it.toDto() }.groupBy { it.type.name }
)
