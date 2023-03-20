package com.github.andreldsr.gymup.data.workoutplan.projections

import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import java.util.UUID

interface WorkoutPlanListProjetionDto {
    fun getName(): String
    fun getIdentifier(): UUID
}

fun WorkoutPlanListProjetionDto.toDto() = WorkoutPlanListDto(
    getName(),
    getIdentifier()
)
