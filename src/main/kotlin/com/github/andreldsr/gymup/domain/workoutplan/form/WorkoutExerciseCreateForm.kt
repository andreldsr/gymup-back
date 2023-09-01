package com.github.andreldsr.gymup.domain.workoutplan.form

import java.util.UUID

data class WorkoutExerciseCreateForm(
    val exerciseIdentifier: UUID,
    val series: Int,
    val repetitions: Int
)