package com.github.andreldsr.gymup.domain.dto

import com.github.andreldsr.gymup.domain.model.MuscleGroup
import java.util.UUID

data class MuscleGroupListDto(
    val identifier: UUID,
    val name: String
)

fun MuscleGroup.toListDto() = MuscleGroupListDto(
    identifier, name
)