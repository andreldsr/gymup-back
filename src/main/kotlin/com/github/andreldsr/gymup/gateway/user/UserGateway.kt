package com.github.andreldsr.gymup.gateway.user

import com.github.andreldsr.gymup.domain.user.model.User
import java.util.UUID

interface UserGateway {
    fun create(user: User): User
    fun delete(identifier: UUID)
    fun findByIdentifier(identifier: UUID): User
    fun findByEmail(email: String): User
}
