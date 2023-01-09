package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.musclegroup.dto.MuscleGroupListDto
import com.github.andreldsr.gymup.domain.musclegroup.form.MuscleGroupCreateForm
import java.util.UUID

interface MuscleGroupService {
    fun create(muscleGroupCreateForm: MuscleGroupCreateForm): MuscleGroupListDto
    fun delete(identifier: UUID)
    fun findAll(): List<MuscleGroupListDto>
}