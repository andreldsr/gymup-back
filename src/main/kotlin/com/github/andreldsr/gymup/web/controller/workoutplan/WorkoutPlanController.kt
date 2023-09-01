package com.github.andreldsr.gymup.web.controller.workoutplan

import com.github.andreldsr.gymup.domain.workoutplan.dto.WorkoutPlanDetailDto
import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import com.github.andreldsr.gymup.service.WorkoutPlanService
import io.micrometer.observation.Observation
import io.micrometer.observation.ObservationRegistry
import io.micrometer.observation.annotation.Observed
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.function.Supplier

@RestController("Workout Plan")
@RequestMapping("/workoutplan")
class WorkoutPlanController(val workoutPlanService: WorkoutPlanService, val observationRegistry: ObservationRegistry) {
    @PostMapping
    @Operation(tags = ["Workout Plan"], description = "Create new workout plan")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody workoutPlanCreateForm: WorkoutPlanCreateForm) =
        workoutPlanService.create(workoutPlanCreateForm)

    @GetMapping("/{identifier}")
    @Operation(tags = ["Workout Plan"], description = "Find workout plan by identifier")
    fun findByIdentifier(@PathVariable identifier: UUID): WorkoutPlanDetailDto {
        return Observation
            .createNotStarted("workoutplan-findByIdentifier", this.observationRegistry)
            .observe(Supplier { workoutPlanService.findByIdentifier(identifier) })
    }

    @GetMapping("/user/{identifier}")
    @Observed(name = "workoutplan-findByUser")
    @Operation(tags = ["Workout Plan"], description = "Find workout plan list by user identifier")
    fun findActiveByUserIdentifier(@PathVariable identifier: UUID) =
        workoutPlanService.findActiveByUserIdentifier(identifier)

    @DeleteMapping("/delete/{identifier}")
    @Operation(tags = ["Workout Plan"], description = "Delete workout plan by identifier")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable identifier: UUID) = workoutPlanService.delete(identifier)

    @DeleteMapping("/{identifier}")
    @Operation(tags = ["Workout Plan"], description = "Deactivate workout plan by identifier")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deactivate(@PathVariable identifier: UUID) = workoutPlanService.deactivate(identifier)
}
