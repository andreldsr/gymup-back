package com.github.andreldsr.gymup.service.impl

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
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
        println("Teste")
        return exerciseDatasource.create(exerciseCreateForm.toModel())
    }

    override fun addExtra(extraCreateForm: ExtraCreateForm): ExtraListDto {
        return extraDatasource.create(extraCreateForm.toModel())
    }

    override fun removeExtra(identifier: UUID) {
        return extraDatasource.delete(identifier)
    }

    override fun delete(identifier: UUID) {
        return exerciseDatasource.delete(identifier)
    }

    override fun findAll(): List<ExerciseListDto> {
        return exerciseDatasource.findAll()
    }

    override fun findByIdentifier(identifier: UUID): ExerciseDetailDto? {
        return exerciseDatasource.findByIdentifier(identifier)
    }

    override fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto> {
        return exerciseDatasource.findByMuscleGroup(identifier)
    }
}
