package com.github.andreldsr.gymup.data.musclegroup.repository

import com.github.andreldsr.gymup.data.musclegroup.entity.MuscleGroupEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MuscleGroupRepository : JpaRepository<MuscleGroupEntity, Long> {
    fun findByIdentifier(identifier: UUID): MuscleGroupEntity?
}
