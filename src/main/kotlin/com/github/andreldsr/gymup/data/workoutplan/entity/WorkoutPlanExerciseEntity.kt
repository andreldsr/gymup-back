package com.github.andreldsr.gymup.data.workoutplan.entity

import com.github.andreldsr.gymup.data.exercise.entity.ExerciseEntity
import com.github.andreldsr.gymup.data.exercise.entity.toEntity
import com.github.andreldsr.gymup.data.exercise.entity.toModel
import com.github.andreldsr.gymup.data.user.entity.UserEntity
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutExercise
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "workout_plan_exercise")
data class WorkoutPlanExerciseEntity(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_plan_id")
    val workoutPlan: WorkoutPlanEntity,
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    val exercise: ExerciseEntity,
    val sets: Int,
    val repetitions: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as WorkoutPlanExerciseEntity
        return workoutPlan.id == other.workoutPlan.id && other.exercise.id == exercise.id
    }

    override fun hashCode(): Int {
        return workoutPlan.id.hashCode() + exercise.id.hashCode()
    }

    override fun toString(): String {
        return "id => $workoutPlan.id - $exercise.id"
    }
}

fun WorkoutPlanExerciseEntity.toModel() = WorkoutExercise(
    exercise.toModel(),
    workoutPlan.toModel(),
    sets,
    repetitions
)

fun WorkoutExercise.toEntity() = WorkoutPlanExerciseEntity(
    workoutPlan = workoutPlan.toEntity(),
    exercise = exercise.toEntity(),
    sets = sets,
    repetitions = repetitions
)