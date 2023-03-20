package com.github.andreldsr.gymup.data.exercise.projections

import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
import com.github.andreldsr.gymup.domain.exercise.model.ExtraType

interface ExtraListProjectionDto {
    fun getDescription(): String
    fun getOrder(): Int
    fun getType(): ExtraType
}

fun ExtraListProjectionDto.toDto() = ExtraListDto(
    getDescription(),
    getOrder(),
    getType()
)
