package com.github.andreldsr.gymup.data.workoutplan.entity

import com.github.andreldsr.gymup.data.exercise.entity.ExerciseEntity
import com.github.andreldsr.gymup.data.exercise.entity.toEntity
import com.github.andreldsr.gymup.data.exercise.entity.toModel
import com.github.andreldsr.gymup.data.user.entity.UserEntity
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "workout_plan")
data class WorkoutPlanEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val identifier: UUID,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,
    val active: Boolean,
    @ManyToMany
    val exercises: List<ExerciseEntity>
)

fun WorkoutPlanEntity.toModel() = WorkoutPlan(
    id, identifier, name, user.identifier, active, exercises.map { it.toModel() }
)

fun WorkoutPlan.toEntity() = WorkoutPlanEntity(
    id, identifier, name, UserEntity(identifier = identifier),active, exercises.map { it.toEntity() }
)