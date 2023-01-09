package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.form.ExerciseCreateForm
import java.util.UUID

interface ExerciseService {
    fun create(exerciseCreateForm: ExerciseCreateForm): ExerciseDetailDto
    fun delete(identifier: UUID)
    fun findAll(): List<ExerciseListDto>
    fun findByIdentifier(identifier: UUID): ExerciseDetailDto
    fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto>
}