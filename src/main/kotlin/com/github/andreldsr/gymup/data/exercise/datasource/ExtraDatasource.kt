package com.github.andreldsr.gymup.data.exercise.datasource

import com.github.andreldsr.gymup.data.exercise.entity.toEntity
import com.github.andreldsr.gymup.data.exercise.entity.toModel
import com.github.andreldsr.gymup.data.exercise.projections.toDto
import com.github.andreldsr.gymup.data.exercise.repository.ExerciseRepository
import com.github.andreldsr.gymup.data.exercise.repository.ExtraRepository
import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
import com.github.andreldsr.gymup.domain.exercise.dto.toListDto
import com.github.andreldsr.gymup.domain.exercise.exception.ExerciseNotFoundException
import com.github.andreldsr.gymup.domain.exercise.exception.ExtraNotFoundException
import com.github.andreldsr.gymup.domain.exercise.model.Extra
import com.github.andreldsr.gymup.gateway.exercise.ExtraGateway
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ExtraDatasource(
    private val extraRepository: ExtraRepository,
    private val exerciseRepository: ExerciseRepository
) : ExtraGateway {
    override fun create(extra: Extra): ExtraListDto {
        val exercise =
            exerciseRepository.findByIdentifier(extra.exercise.identifier) ?: throw ExerciseNotFoundException(
                extra.exercise.identifier
            )
        return extraRepository.save(
            extra
                .toEntity()
                .copy(exercise = exercise)
        ).toModel().toListDto()
    }

    override fun delete(identifier: UUID) {
        val extra = extraRepository.findByIdentifier(identifier) ?: throw ExtraNotFoundException(identifier)
        extraRepository.delete(extra)
    }

    override fun findByExerciseIdentifier(identifier: UUID): List<ExtraListDto> {
        return extraRepository.findListByExerciseIdentifier(identifier).map { it.toDto() }
    }
}
