package com.github.andreldsr.gymup.data.musclegroup.projections

import com.github.andreldsr.gymup.domain.musclegroup.dto.MuscleGroupListDto
import java.util.UUID

interface MuscleGroupListProjectionDto {
    fun getIdentifier(): UUID
    fun getName(): String
}

fun MuscleGroupListProjectionDto.toDto() = MuscleGroupListDto(
    getIdentifier(),
    getName()
)
