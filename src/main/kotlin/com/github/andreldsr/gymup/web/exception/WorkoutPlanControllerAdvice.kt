package com.github.andreldsr.gymup.web.exception

import com.github.andreldsr.gymup.domain.workoutplan.exception.WorkoutPlanNotFoundException
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class WorkoutPlanControllerAdvice {
    @ExceptionHandler
    fun handleWorkoutPlanNotFoundException(e: WorkoutPlanNotFoundException): ProblemDetail {
        val pd = ProblemDetail.forStatus(404)
        pd.title = "Workout plan not found"
        pd.detail = e.message
        return pd
    }
}
