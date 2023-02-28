package com.github.andreldsr.gymup.domain.musclegroup.exception

import java.util.UUID

data class MuscleGroupNotFoundException(val identifier: UUID) : Exception("Muscle group $identifier not found")
