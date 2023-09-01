package com.github.andreldsr.gymup.domain.workoutplan.exception

import java.util.UUID

data class WorkoutPlanNotFoundException(val identifier: UUID) : Exception("Workout plan $identifier not found")
