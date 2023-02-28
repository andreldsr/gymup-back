package com.github.andreldsr.gymup.data.exercise.repository

import com.github.andreldsr.gymup.data.exercise.entity.ExtraEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExtraRepository : JpaRepository<ExtraEntity, Long> {
    fun findByExerciseIdentifier(identifier: UUID): List<ExtraEntity>
    fun findByIdentifier(identifier: UUID): ExtraEntity?
}
