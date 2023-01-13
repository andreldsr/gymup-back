package com.github.andreldsr.gymup.domain.user.form

import com.github.andreldsr.gymup.domain.user.model.Role

data class RoleCreateForm(
    val name: String
)

fun RoleCreateForm.toModel() = Role(name = name)
