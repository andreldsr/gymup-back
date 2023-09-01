package com.github.andreldsr.gymup.web.exception

import com.github.andreldsr.gymup.domain.exercise.exception.ExerciseNotFoundException
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExerciseControllerAdvice {
    @ExceptionHandler
    fun handleExerciseNotFoundException(e: ExerciseNotFoundException): ProblemDetail {
        val pd = ProblemDetail.forStatus(404)
        pd.title = "Exercise not found"
        pd.detail = e.message
        return pd
    }
}
