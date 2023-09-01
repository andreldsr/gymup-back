package com.github.andreldsr.gymup.data.workoutplan.datasource

import com.github.andreldsr.gymup.data.user.entity.toEntity
import com.github.andreldsr.gymup.data.workoutplan.entity.toEntity
import com.github.andreldsr.gymup.data.workoutplan.entity.toModel
import com.github.andreldsr.gymup.data.workoutplan.projections.toDto
import com.github.andreldsr.gymup.data.workoutplan.repository.WorkoutPlanRepository
import com.github.andreldsr.gymup.domain.user.model.User
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import com.github.andreldsr.gymup.domain.workoutplan.exception.WorkoutPlanNotFoundException
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import com.github.andreldsr.gymup.gateway.workoutplan.WorkoutPlanGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class WorkoutPlanDatasource(val workoutPlanRepository: WorkoutPlanRepository) : WorkoutPlanGateway {
    override fun create(workoutPlan: WorkoutPlan, user: User): WorkoutPlan {
        val entity = workoutPlan.toEntity().copy(user = user.toEntity())
        entity.exercises = workoutPlan.exercises.map { e -> e.toEntity().copy(workoutPlan = entity) }
        return workoutPlanRepository.save(entity).toModel()
    }

    override fun delete(identifier: UUID) {
        workoutPlanRepository.deleteByIdentifier(identifier)
    }

    override fun findActiveByUserIdentifier(identifier: UUID): List<WorkoutPlanListDto> {
        return workoutPlanRepository.findByUserIdentifierAndActiveIsTrue(identifier).map { it.toDto() }
    }

    override fun findByIdentifier(identifier: UUID): WorkoutPlanDetailDto {
        return workoutPlanRepository.findDetailByIdentifier(identifier)?.toDto()
            ?: throw WorkoutPlanNotFoundException(identifier)
    }

    override fun deactivate(identifier: UUID) {
        val plan = workoutPlanRepository.findByIdentifier(identifier)
        workoutPlanRepository.save(plan.copy(active = false))
    }
}
