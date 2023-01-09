package com.github.andreldsr.gymup

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class GymupApplication

fun main(args: Array<String>) {
    runApplication<GymupApplication>(*args)
}
