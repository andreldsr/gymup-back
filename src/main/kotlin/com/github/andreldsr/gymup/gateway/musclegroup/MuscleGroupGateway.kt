package com.github.andreldsr.gymup.gateway.musclegroup

import com.github.andreldsr.gymup.domain.musclegroup.dto.MuscleGroupListDto
import com.github.andreldsr.gymup.domain.musclegroup.form.MuscleGroupCreateForm
import java.util.UUID

interface MuscleGroupGateway {
    fun create(muscleGroup: MuscleGroupCreateForm): MuscleGroupListDto
    fun delete(identifier: UUID)
    fun findAll(): List<MuscleGroupListDto>
}
