package com.github.andreldsr.gymup.service

import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseDetailDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExerciseListDto
import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
import com.github.andreldsr.gymup.domain.exercise.form.ExerciseCreateForm
import com.github.andreldsr.gymup.domain.exercise.form.ExtraCreateForm
import java.util.UUID

interface ExerciseService {
    fun create(exerciseCreateForm: ExerciseCreateForm): ExerciseDetailDto
    fun addExtra(extraCreateForm: ExtraCreateForm): ExtraListDto
    fun removeExtra(identifier: UUID)
    fun delete(identifier: UUID)
    fun findAll(): List<ExerciseListDto>
    fun findByIdentifier(identifier: UUID): ExerciseDetailDto?
    fun findByMuscleGroup(identifier: UUID): List<ExerciseListDto>
}