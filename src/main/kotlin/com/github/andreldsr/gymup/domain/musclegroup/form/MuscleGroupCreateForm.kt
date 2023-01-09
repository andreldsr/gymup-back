package com.github.andreldsr.gymup.domain.musclegroup.form

import com.github.andreldsr.gymup.domain.musclegroup.model.MuscleGroup

data class MuscleGroupCreateForm(
    val name: String
)

fun MuscleGroupCreateForm.toModel() = MuscleGroup(name = name)