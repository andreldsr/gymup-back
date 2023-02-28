package com.github.andreldsr.gymup.data.exercise.datasource

import com.github.andreldsr.gymup.data.exercise.entity.toEntity
import com.github.andreldsr.gymup.data.exercise.entity.toModel
import com.github.andreldsr.gymup.data.exercise.repository.ExerciseRepository
import com.github.andreldsr.gymup.data.musclegroup.repository.MuscleGroupRepository
import com.github.andreldsr.gymup.domain.exercise.exception.ExerciseNotFoundException
import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import com.github.andreldsr.gymup.gateway.exercise.ExerciseGateway
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
        val exercise = exerciseRepository.findByIdentifier(identifier) ?: throw ExerciseNotFoundException(identifier)
        exerciseRepository.delete(exercise)
    }

    override fun findAll(): List<Exercise> {
        return exerciseRepository.findAll().map { it.toModel() }
    }

    override fun findByIdentifier(identifier: UUID): Exercise {
        return exerciseRepository.findByIdentifier(identifier)?.toModel() ?: throw ExerciseNotFoundException(identifier)
    }

    override fun findByMuscleGroup(identifier: UUID): List<Exercise> {
        return exerciseRepository.findAllByGroupIdentifier(identifier).map { it.toModel() }
    }
}
