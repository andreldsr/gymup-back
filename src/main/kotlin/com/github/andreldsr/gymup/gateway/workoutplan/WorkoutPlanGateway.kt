package com.github.andreldsr.gymup.gateway.workoutplan

import com.github.andreldsr.gymup.domain.user.model.User
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import java.util.UUID

interface WorkoutPlanGateway {
    fun create(workoutPlan: WorkoutPlan, user: User): WorkoutPlan
    fun delete(identifier: UUID)
    fun findActiveByUserIdentifier(identifier: UUID): List<WorkoutPlanListDto>
    fun findByIdentifier(identifier: UUID): WorkoutPlanDetailDto
    fun deactivate(identifier: UUID)
}
