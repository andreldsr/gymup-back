package com.github.andreldsr.gymup.domain.exercise.exception

import java.util.UUID

data class ExtraNotFoundException(val identifier: UUID): Exception("Extra $identifier not found")
