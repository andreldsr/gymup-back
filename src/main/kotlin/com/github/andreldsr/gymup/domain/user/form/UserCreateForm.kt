package com.github.andreldsr.gymup.domain.user.form

import com.github.andreldsr.gymup.domain.user.model.User

data class UserCreateForm(
    val name: String,
    val email: String,
    val password: String
)

fun UserCreateForm.toModel() = User(name= name, email = email, password = password)