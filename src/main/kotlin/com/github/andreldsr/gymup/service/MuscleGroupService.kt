package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.dto.MuscleGroupListDto
import com.github.andreldsr.gymup.domain.form.MuscleGroupCreateForm
import java.util.UUID

interface MuscleGroupService {
    fun create(muscleGroupCreateForm: MuscleGroupCreateForm): MuscleGroupListDto
    fun delete(identifier: UUID)
    fun findAll(): List<MuscleGroupListDto>
}