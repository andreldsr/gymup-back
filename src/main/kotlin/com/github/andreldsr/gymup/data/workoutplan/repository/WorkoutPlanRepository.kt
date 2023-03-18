package com.github.andreldsr.gymup.data.workoutplan.repository

import com.github.andreldsr.gymup.data.workoutplan.entity.WorkoutPlanEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WorkoutPlanRepository: JpaRepository<WorkoutPlanEntity, Long> {
    fun findByIdentifier(identifier: UUID): WorkoutPlanEntity
    fun findByUserIdentifierAndActiveIsTrue(identifier: UUID): List<WorkoutPlanEntity>
    fun deleteByIdentifier(identifier: UUID)
}