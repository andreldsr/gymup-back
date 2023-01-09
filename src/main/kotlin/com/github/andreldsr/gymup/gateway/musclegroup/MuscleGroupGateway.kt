package com.github.andreldsr.gymup.gateway.musclegroup

import com.github.andreldsr.gymup.domain.musclegroup.model.MuscleGroup
import java.util.UUID

interface MuscleGroupGateway {
    fun create(muscleGroup: MuscleGroup): MuscleGroup
    fun delete(identifier: UUID)
    fun findAll(): List<MuscleGroup>
}