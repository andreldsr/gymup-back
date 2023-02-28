package com.github.andreldsr.gymup.domain.exercise.exception

import java.util.UUID

data class ExerciseNotFoundException(val identifier: UUID) : Exception("Exercise $identifier not found")
