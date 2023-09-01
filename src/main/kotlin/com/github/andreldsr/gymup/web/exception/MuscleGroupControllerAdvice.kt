package com.github.andreldsr.gymup.web.exception

import com.github.andreldsr.gymup.domain.musclegroup.exception.MuscleGroupNotFoundException
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class MuscleGroupControllerAdvice {
    @ExceptionHandler
    fun handleMuscleGroupNotFoundException(e: MuscleGroupNotFoundException): ProblemDetail {
        val pd = ProblemDetail.forStatus(404)
        pd.title = "Muscle group not found"
        pd.detail = e.message
        return pd
    }
}
