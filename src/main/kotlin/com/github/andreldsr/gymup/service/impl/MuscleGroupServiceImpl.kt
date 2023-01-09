package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.gateway.musclegroup.MuscleGroupGateway
import com.github.andreldsr.gymup.domain.musclegroup.dto.MuscleGroupListDto
import com.github.andreldsr.gymup.domain.musclegroup.dto.toListDto
import com.github.andreldsr.gymup.domain.musclegroup.form.MuscleGroupCreateForm
import com.github.andreldsr.gymup.domain.musclegroup.form.toModel
import com.github.andreldsr.gymup.service.MuscleGroupService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MuscleGroupServiceImpl(private val muscleGroupDatasource: MuscleGroupGateway) : MuscleGroupService {
    override fun create(muscleGroupCreateForm: MuscleGroupCreateForm): MuscleGroupListDto {
        return muscleGroupDatasource.create(muscleGroupCreateForm.toModel()).toListDto()
    }

    override fun delete(identifier: UUID) {
        muscleGroupDatasource.delete(identifier)
    }

    override fun findAll(): List<MuscleGroupListDto> {
        return muscleGroupDatasource.findAll().map { it.toListDto() }
    }
}