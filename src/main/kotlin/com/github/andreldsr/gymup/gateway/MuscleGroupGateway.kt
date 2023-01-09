package com.github.andreldsr.gymup.gateway

import com.github.andreldsr.gymup.domain.model.MuscleGroup
import java.util.UUID

interface MuscleGroupGateway {
    fun create(muscleGroup: MuscleGroup): MuscleGroup
    fun delete(identifier: UUID)
    fun findAll(): List<MuscleGroup>
}