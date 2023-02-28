package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
import com.github.andreldsr.gymup.domain.exercise.dto.toDetailDto
import com.github.andreldsr.gymup.domain.exercise.dto.toListDto
import com.github.andreldsr.gymup.domain.exercise.form.ExerciseCreateForm
import com.github.andreldsr.gymup.domain.exercise.form.ExtraCreateForm
import com.github.andreldsr.gymup.domain.exercise.form.toModel
import com.github.andreldsr.gymup.gateway.exercise.ExerciseGateway
import com.github.andreldsr.gymup.gateway.exercise.ExtraGateway
import com.github.andreldsr.gymup.service.ExerciseService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ExerciseServiceImpl(private val exerciseDatasource: ExerciseGateway, private val extraDatasource: ExtraGateway) : ExerciseService {
    override fun create(exerciseCreateForm: ExerciseCreateForm): ExerciseDetailDto {
        return exerciseDatasource.create(exerciseCreateForm.toModel()).toDetailDto()
    }

    override fun addExtra(extraCreateForm: ExtraCreateForm): ExtraListDto {
        return extraDatasource.create(extraCreateForm.toModel()).toListDto()
    }

    override fun removeExtra(identifier: UUID) {
        return extraDatasource.delete(identifier)
    }

    override fun delete(identifier: UUID) {
        return exerciseDatasource.delete(identifier)
    }

    override fun findAll(): List<ExerciseListDto> {
        return exerciseDatasource.findAll().map { it.toListDto() }
    }

    override fun findByIdentifier(identifier: UUID): ExerciseDetailDto? {
        val detailDto = exerciseDatasource.findByIdentifier(identifier).toDetailDto()
        return detailDto.copy(extras = getExtras(identifier))
    }

    private fun getExtras(identifier: UUID): Map<String, List<ExtraListDto>> {
        val extras = extraDatasource.findByExerciseIdentifier(identifier).map { it.toListDto() }
        return extras.groupBy { it.type.name }
    }

    override fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto> {
        return exerciseDatasource.findByMuscleGroup(identifier).map { it.toListDto() }
    }
}
