package com.github.andreldsr.gymup.gateway.exercise

import com.github.andreldsr.gymup.domain.exercise.model.Extra
import java.util.UUID

interface ExtraGateway {
    fun create(extra: Extra): Extra
    fun delete(identifier: UUID)
    fun findByExerciseIdentifier(identifier: UUID): List<Extra>
}
