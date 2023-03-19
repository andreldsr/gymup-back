package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.toDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import com.github.andreldsr.gymup.domain.workoutplan.form.toModel
import com.github.andreldsr.gymup.gateway.exercise.ExerciseGateway
import com.github.andreldsr.gymup.gateway.user.UserGateway
import com.github.andreldsr.gymup.gateway.workoutplan.WorkoutPlanGateway
import com.github.andreldsr.gymup.service.WorkoutPlanService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class WorkoutPlanServiceImpl(
    val workoutPlanGateway: WorkoutPlanGateway,
    val userGateway: UserGateway,
    val exerciGateway: ExerciseGateway
) : WorkoutPlanService {
    override fun create(workoutPlanCreateForm: WorkoutPlanCreateForm): WorkoutPlanDetailDto {
        val user = userGateway.findByIdentifier(workoutPlanCreateForm.userIdentifier)
        val exercises = exerciGateway.findAllByIdentifier(workoutPlanCreateForm.exercises.map { it.identifier })
        return workoutPlanGateway.create(workoutPlanCreateForm.toModel().copy(exercises = exercises), user)
            .toDetailDto()
    }

    override fun findByIdentifier(identifier: UUID): WorkoutPlanDetailDto {
        return workoutPlanGateway.findByIdentifier(identifier)
    }

    override fun findActiveByUserIdentifier(identifier: UUID): List<WorkoutPlanListDto> {
        return workoutPlanGateway.findActiveByUserIdentifier(identifier)
    }

    override fun delete(identifier: UUID) {
        workoutPlanGateway.delete(identifier)
    }

    override fun deactivate(identifier: UUID) {
        workoutPlanGateway.deactivate(identifier)
    }
}
