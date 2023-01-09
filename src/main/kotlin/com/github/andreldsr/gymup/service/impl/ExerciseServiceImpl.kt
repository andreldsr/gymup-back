package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.gateway.ExerciseGateway
import com.github.andreldsr.gymup.domain.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.dto.toDetailDto
import com.github.andreldsr.gymup.domain.dto.toListDto
import com.github.andreldsr.gymup.domain.form.ExerciseCreateForm
import com.github.andreldsr.gymup.domain.form.toModel
import com.github.andreldsr.gymup.service.ExerciseService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ExerciseServiceImpl(private val exerciseDatasource: ExerciseGateway) : ExerciseService {
    override fun create(exerciseCreateForm: ExerciseCreateForm): ExerciseDetailDto {
        return exerciseDatasource.create(exerciseCreateForm.toModel()).toDetailDto()
    }

    override fun delete(identifier: UUID) {
        return exerciseDatasource.delete(identifier)
    }

    override fun findAll(): List<ExerciseListDto> {
        return exerciseDatasource.findAll().map { it.toListDto() }
    }

    override fun findByIdentifier(identifier: UUID): ExerciseDetailDto {
        return exerciseDatasource.findByIdentifier(identifier).toDetailDto()
    }

    override fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto> {
        return exerciseDatasource.findByMuscleGroup(identifier).map { it.toListDto() }
    }
}