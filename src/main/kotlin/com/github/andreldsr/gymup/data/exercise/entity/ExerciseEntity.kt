package com.github.andreldsr.gymup.data.exercise.entity

import com.github.andreldsr.gymup.data.musclegroup.entity.MuscleGroupEntity
import com.github.andreldsr.gymup.data.musclegroup.entity.toEntity
import com.github.andreldsr.gymup.data.musclegroup.entity.toModel
import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "exercise")
data class ExerciseEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val identifier: UUID,
    val name: String,
    val description: String,
    @ManyToOne
    val group: MuscleGroupEntity? = null,
    @CreatedDate @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

fun ExerciseEntity.toModel() = Exercise(
    id = id,
    identifier= identifier,
    name = name,
    description = description,
    group = group?.toModel()
)

fun Exercise.toEntity() = ExerciseEntity(
    id = id,
    identifier= identifier,
    name = name,
    description = description,
    group = group?.toEntity()
)