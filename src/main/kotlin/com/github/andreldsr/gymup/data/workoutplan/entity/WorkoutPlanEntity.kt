package com.github.andreldsr.gymup.data.workoutplan.entity

import com.github.andreldsr.gymup.data.user.entity.UserEntity
import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import com.github.andreldsr.gymup.domain.workoutplan.form.toModel
import com.github.andreldsr.gymup.domain.workoutplan.model.WorkoutPlan
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "workout_plan")
data class WorkoutPlanEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val identifier: UUID = UUID.randomUUID(),
    val name: String = "",
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserEntity,
    val active: Boolean = true,
    @OneToMany(mappedBy = "workoutPlan", cascade = [CascadeType.ALL], orphanRemoval = true)
    var exercises: List<WorkoutPlanExerciseEntity> = listOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as WorkoutPlanEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "id => $id || identifier => $identifier || name => $name"
    }
}

fun WorkoutPlanEntity.toModel() = WorkoutPlan(
    id,
    identifier,
    name,
    user.identifier,
    active
)

fun WorkoutPlan.toEntity() = WorkoutPlanEntity(
    id,
    identifier,
    name,
    UserEntity(identifier = identifier),
    active
)

fun WorkoutPlanCreateForm.toEntity() = toModel().toEntity()
