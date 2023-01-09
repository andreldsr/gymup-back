package com.github.andreldsr.gymup.domain.form

import com.github.andreldsr.gymup.domain.model.MuscleGroup

data class MuscleGroupCreateForm(
    val name: String
)

fun MuscleGroupCreateForm.toModel() = MuscleGroup(name = name)