package com.github.andreldsr.gymup.data.datasource

import com.github.andreldsr.gymup.data.entity.toEntity
import com.github.andreldsr.gymup.data.entity.toModel
import com.github.andreldsr.gymup.data.repository.ExerciseRepository
import com.github.andreldsr.gymup.data.repository.MuscleGroupRepository
import com.github.andreldsr.gymup.gateway.ExerciseGateway
import com.github.andreldsr.gymup.domain.model.Exercise
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ExerciseDatasource(
    private val exerciseRepository: ExerciseRepository,
    private val muscleGroupRepository: MuscleGroupRepository
) : ExerciseGateway {
    override fun create(exercise: Exercise): Exercise {
        val muscleGroup = muscleGroupRepository.findByIdentifier(exercise.group!!.identifier)
        return exerciseRepository.save(exercise.toEntity().copy(group = muscleGroup)).toModel()
    }

    override fun delete(identifier: UUID) {
        exerciseRepository.delete(exerciseRepository.findByIdentifier(identifier))
    }

    override fun findAll(): List<Exercise> {
        return exerciseRepository.findAll().map { it.toModel() }
    }

    override fun findByIdentifier(identifier: UUID): Exercise {
        return exerciseRepository.findByIdentifier(identifier).toModel()
    }

    override fun findByMuscleGroup(identifier: UUID): List<Exercise> {
        return exerciseRepository.findAllByGroupIdentifier(identifier).map { it.toModel() }
    }
}