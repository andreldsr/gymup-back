package com.github.andreldsr.gymup.gateway.exercise

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import java.util.UUID

interface ExerciseGateway {
    fun create(exercise: Exercise): ExerciseDetailDto
    fun delete(identifier: UUID)
    fun findAll(): List<ExerciseListDto>
    fun findByIdentifier(identifier: UUID): ExerciseDetailDto
    fun findAllByIdentifier(identifiers: List<UUID>): List<Exercise>
    fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto>
}
