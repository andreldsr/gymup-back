package com.github.andreldsr.gymup.data.workoutplan.datasource

import com.github.andreldsr.gymup.data.exercise.entity.toEntity
import com.github.andreldsr.gymup.data.user.entity.toEntity
import com.github.andreldsr.gymup.data.workoutplan.entity.toEntity
import com.github.andreldsr.gymup.data.workoutplan.entity.toModel
import com.github.andreldsr.gymup.data.workoutplan.repository.WorkoutPlanRepository
import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import com.github.andreldsr.gymup.domain.user.model.User
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.toDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.toListDto
import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import com.github.andreldsr.gymup.gateway.workoutplan.WorkoutPlanGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class WorkoutPlanDatasource(val workoutPlanRepository: WorkoutPlanRepository) : WorkoutPlanGateway {
    override fun create(workoutPlan: WorkoutPlanCreateForm, user: User, exercises: List<Exercise>): WorkoutPlan {
        return workoutPlanRepository.save(
            workoutPlan
                .toEntity()
                .copy(user = user.toEntity(), exercises = exercises.map { it.toEntity() })
        ).toModel()
    }

    override fun delete(identifier: UUID) {
        workoutPlanRepository.deleteByIdentifier(identifier)
    }

    override fun findActiveByUserIdentifier(identifier: UUID): List<WorkoutPlanListDto> {
        return workoutPlanRepository.findByUserIdentifierAndActiveIsTrue(identifier).map { it.toModel().toListDto() }
    }

    override fun findByIdentifier(identifier: UUID): WorkoutPlanDetailDto {
        return workoutPlanRepository.findByIdentifier(identifier).toModel().toDetailDto()
    }

    override fun deactivate(identifier: UUID) {
        val plan = workoutPlanRepository.findByIdentifier(identifier)
        workoutPlanRepository.save(plan.copy(active = false))
    }
}