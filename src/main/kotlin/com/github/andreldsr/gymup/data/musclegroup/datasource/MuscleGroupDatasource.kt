package com.github.andreldsr.gymup.data.musclegroup.datasource

import com.github.andreldsr.gymup.data.musclegroup.entity.toEntity
import com.github.andreldsr.gymup.data.musclegroup.entity.toModel
import com.github.andreldsr.gymup.data.musclegroup.repository.MuscleGroupRepository
import com.github.andreldsr.gymup.domain.musclegroup.dto.MuscleGroupListDto
import com.github.andreldsr.gymup.domain.musclegroup.dto.toListDto
import com.github.andreldsr.gymup.domain.musclegroup.exception.MuscleGroupNotFoundException
import com.github.andreldsr.gymup.domain.musclegroup.form.MuscleGroupCreateForm
import com.github.andreldsr.gymup.gateway.musclegroup.MuscleGroupGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MuscleGroupDatasource(private val muscleGroupRepository: MuscleGroupRepository) : MuscleGroupGateway {
    override fun create(muscleGroup: MuscleGroupCreateForm): MuscleGroupListDto {
        return muscleGroupRepository.save(muscleGroup.toEntity()).toModel().toListDto()
    }

    override fun delete(identifier: UUID) {
        val muscleGroup =
            muscleGroupRepository.findByIdentifier(identifier) ?: throw MuscleGroupNotFoundException(identifier)
        muscleGroupRepository.delete(muscleGroup)
    }

    override fun findAll(): List<MuscleGroupListDto> {
        return muscleGroupRepository.findAll().map { it.toModel().toListDto() }
    }
}
