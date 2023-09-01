package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanListDto
import com.github.andreldsr.gymup.domain.workoutplan.dto.toDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import com.github.andreldsr.gymup.domain.workoutplan.form.toModel
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutExercise
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
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
        val workoutPlan = workoutPlanCreateForm.toModel()
        val user = userGateway.findByIdentifier(workoutPlanCreateForm.userIdentifier)
        val exercises = getWorkoutExercises(workoutPlanCreateForm, workoutPlan)
        return workoutPlanGateway.create(workoutPlan.copy(exercises = exercises), user)
            .toDetailDto()
    }

    private fun getWorkoutExercises(
        workoutPlanCreateForm: WorkoutPlanCreateForm,
        workoutPlan: WorkoutPlan
    ): List<WorkoutExercise> {
        val exerciseMap = exerciGateway
            .findAllByIdentifier(workoutPlanCreateForm.exercises.map { it.exerciseIdentifier })
            .associateBy { it.identifier }
        val exercises = workoutPlanCreateForm
            .exercises
            .map {
                if (exerciseMap.containsKey(it.exerciseIdentifier))
                    WorkoutExercise(exerciseMap[it.exerciseIdentifier]!!, workoutPlan, it.series, it.repetitions)
                else
                    null
            }.mapNotNull { it }
        return exercises
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
