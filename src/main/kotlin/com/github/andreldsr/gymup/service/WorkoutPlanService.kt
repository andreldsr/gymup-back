package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import java.util.UUID

interface WorkoutPlanService {
    fun create(workoutPlanCreateForm: WorkoutPlanCreateForm): WorkoutPlanDetailDto
    fun findByIdentifier(identifier: UUID): WorkoutPlanDetailDto
    fun findActiveByUserIdentifier(identifier: UUID): List<WorkoutPlanListDto>
    fun delete(identifier: UUID)
    fun deactivate(identifier: UUID)
}
