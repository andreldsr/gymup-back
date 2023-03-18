package com.github.andreldsr.gymup.gateway.workoutplan

import com.github.andreldsr.gymup.domain.user.model.User
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import java.util.UUID

interface WorkoutPlanGateway {
    fun create(workoutPlan: WorkoutPlan, user: User): WorkoutPlan
    fun delete(identifier: UUID)
    fun findActiveByUserIdentifier(identifier: UUID): List<WorkoutPlan>
    fun findByIdentifier(identifier: UUID): WorkoutPlan
    fun deactivate(identifier: UUID)
}