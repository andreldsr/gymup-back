package com.github.andreldsr.gymup.domain.workoutplan.model

import com.github.andreldsr.gymup.domain.exercise.model.Exercise

data class WorkoutExercise(
    val exercise: Exercise,
    val workoutPlan: WorkoutPlan,
    val sets: Int = 0,
    val repetitions: Int = 0
)
