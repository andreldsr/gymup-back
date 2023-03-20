package com.github.andreldsr.gymup.data.exercise.datasource

import com.github.andreldsr.gymup.data.exercise.entity.toDetailDto
import com.github.andreldsr.gymup.data.exercise.entity.toEntity
import com.github.andreldsr.gymup.data.exercise.entity.toModel
import com.github.andreldsr.gymup.data.exercise.projections.toDto
import com.github.andreldsr.gymup.data.exercise.repository.ExerciseRepository
import com.github.andreldsr.gymup.data.musclegroup.repository.MuscleGroupRepository
import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
import com.github.andreldsr.gymup.domain.exercise.exception.ExerciseNotFoundException
import com.github.andreldsr.gymup.domain.exercise.model.Exercise
import com.github.andreldsr.gymup.gateway.exercise.ExerciseGateway
import com.github.andreldsr.gymup.gateway.exercise.ExtraGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ExerciseDatasource(
    private val exerciseRepository: ExerciseRepository,
    private val muscleGroupRepository: MuscleGroupRepository,
    private val extraDatasource: ExtraGateway
) : ExerciseGateway {
    override fun create(exercise: Exercise): ExerciseDetailDto {
        val muscleGroup = muscleGroupRepository.findByIdentifier(exercise.group!!.identifier)
        return exerciseRepository.save(
            exercise
                .toEntity()
                .copy(group = muscleGroup)
        ).toDetailDto()
    }

    override fun delete(identifier: UUID) {
        if (exerciseRepository.existsByIdentifier(identifier)) {
            exerciseRepository.deleteByIdentifier(identifier)
        } else {
            throw ExerciseNotFoundException(identifier)
        }
    }

    override fun findAll(): List<ExerciseListDto> {
        return exerciseRepository.findBy().map { it.toDto() }
    }

    override fun findByIdentifier(identifier: UUID): ExerciseDetailDto {
        return exerciseRepository.findDetailByIdentifier(identifier)
            ?.toDto()
            ?.copy(extras = getExtras(identifier))
            ?: throw ExerciseNotFoundException(identifier)
    }

    private fun getExtras(identifier: UUID): Map<String, List<ExtraListDto>> {
        val extras = extraDatasource.findByExerciseIdentifier(identifier)
        return extras.groupBy { it.type.name }
    }

    override fun findAllByIdentifier(identifiers: List<UUID>): List<Exercise> {
        return exerciseRepository.findAllByIdentifierIn(identifiers).map { it.toModel() }
    }

    override fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto> {
        return exerciseRepository.findAllByGroupIdentifier(identifier).map { it.toDto() }
    }
}
