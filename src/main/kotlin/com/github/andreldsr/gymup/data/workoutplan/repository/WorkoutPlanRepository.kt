package com.github.andreldsr.gymup.data.workoutplan.repository

import com.github.andreldsr.gymup.data.workoutplan.entity.WorkoutPlanEntity
import com.github.andreldsr.gymup.data.workoutplan.projections.WorkoutPlanDetailProjectionDto
import com.github.andreldsr.gymup.data.workoutplan.projections.WorkoutPlanListProjetionDto
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WorkoutPlanRepository : JpaRepository<WorkoutPlanEntity, Long> {
    fun findByIdentifier(identifier: UUID): WorkoutPlanEntity
    @EntityGraph(attributePaths = ["exercises.exercise", "user", "exercises.exercise.group"])
    fun findDetailByIdentifier(identifier: UUID): WorkoutPlanDetailProjectionDto?

    fun findByUserIdentifierAndActiveIsTrue(identifier: UUID): List<WorkoutPlanListProjetionDto>
    fun deleteByIdentifier(identifier: UUID)
}
