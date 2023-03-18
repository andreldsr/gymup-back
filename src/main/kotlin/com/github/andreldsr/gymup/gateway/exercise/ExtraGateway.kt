package com.github.andreldsr.gymup.gateway.exercise

import com.github.andreldsr.gymup.domain.exercise.dto.ExtraListDto
import com.github.andreldsr.gymup.domain.exercise.form.ExtraCreateForm
import java.util.UUID

interface ExtraGateway {
    fun create(extra: ExtraCreateForm): ExtraListDto
    fun delete(identifier: UUID)
    fun findByExerciseIdentifier(identifier: UUID): List<ExtraListDto>
}
