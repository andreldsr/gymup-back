package com.github.andreldsr.gymup.gateway.exercise

import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import java.util.UUID

interface ExerciseGateway {
    fun create(exercise: Exercise): Exercise
    fun delete(identifier: UUID)
    fun findAll(): List<Exercise>
    fun findByIdentifier(identifier: UUID): Exercise
    fun findByMuscleGroup(identifier: UUID): List<Exercise>
}
