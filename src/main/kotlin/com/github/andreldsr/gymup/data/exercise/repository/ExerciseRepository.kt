package com.github.andreldsr.gymup.data.exercise.repository

import com.github.andreldsr.gymup.data.exercise.entity.ExerciseEntity
import com.github.andreldsr.gymup.data.exercise.projections.ExerciseDetailProjectionDto
import com.github.andreldsr.gymup.data.exercise.projections.ExerciseListProjectionDto
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExerciseRepository : JpaRepository<ExerciseEntity, Long> {

    fun findBy(): List<ExerciseListProjectionDto>
    fun findByIdentifier(identifier: UUID): ExerciseEntity?
    @EntityGraph(attributePaths = ["group", "extras"])
    fun findDetailByIdentifier(identifier: UUID): ExerciseDetailProjectionDto?
    fun findAllByIdentifierIn(identifiers: List<UUID>): List<ExerciseEntity>
    fun findAllByGroupIdentifier(identifier: UUID): List<ExerciseListProjectionDto>
    fun existsByIdentifier(identifier: UUID): Boolean
    fun deleteByIdentifier(identifier: UUID)
}
