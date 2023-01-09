package com.github.andreldsr.gymup.data.datasource

import com.github.andreldsr.gymup.data.entity.toEntity
import com.github.andreldsr.gymup.data.entity.toModel
import com.github.andreldsr.gymup.data.repository.MuscleGroupRepository
import com.github.andreldsr.gymup.gateway.MuscleGroupGateway
import com.github.andreldsr.gymup.domain.model.MuscleGroup
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class MuscleGroupDatasource(private val muscleGroupRepository: MuscleGroupRepository) : MuscleGroupGateway {
    override fun create(muscleGroup: MuscleGroup): MuscleGroup {
        return muscleGroupRepository.save(muscleGroup.toEntity()).toModel()
    }

    override fun delete(identifier: UUID) {
        muscleGroupRepository.delete(muscleGroupRepository.findByIdentifier(identifier))
    }

    override fun findAll(): List<MuscleGroup> {
        return muscleGroupRepository.findAll().map { it.toModel() }
    }
}