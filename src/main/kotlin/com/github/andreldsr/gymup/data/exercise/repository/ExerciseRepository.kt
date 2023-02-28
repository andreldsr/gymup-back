package com.github.andreldsr.gymup.data.exercise.repository

import com.github.andreldsr.gymup.data.exercise.entity.ExerciseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExerciseRepository : JpaRepository<ExerciseEntity, Long> {
    fun findByIdentifier(identifier: UUID): ExerciseEntity?
    fun findAllByGroupIdentifier(identifier: UUID): List<ExerciseEntity>
}
