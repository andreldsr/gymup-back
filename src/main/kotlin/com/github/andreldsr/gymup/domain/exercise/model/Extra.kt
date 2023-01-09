package com.github.andreldsr.gymup.domain.exercise.model

import java.util.UUID

data class Extra(
    val id: Long = 0,
    val identifier: UUID = UUID.randomUUID(),
    val description: String,
    val order: Int = 0,
    val type: ExtraType,
    val exercise: Exercise,
)

enum class ExtraType {
    TIP,
    STEP
}
