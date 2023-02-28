package com.github.andreldsr.gymup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GymupApplication

fun main(args: Array<String>) {
    runApplication<GymupApplication>(*args)
}
