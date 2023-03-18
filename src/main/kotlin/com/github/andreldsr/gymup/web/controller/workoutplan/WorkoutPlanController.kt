package com.github.andreldsr.gymup.web.controller.workoutplan

import com.github.andreldsr.gymup.domain.workoutplan.form.WorkoutPlanCreateForm
import com.github.andreldsr.gymup.service.WorkoutPlanService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController("Workout Plan")
@RequestMapping("/workoutplan")
class WorkoutPlanController(val workoutPlanService: WorkoutPlanService) {
    @PostMapping
    fun create(@RequestBody workoutPlanCreateForm: WorkoutPlanCreateForm) = workoutPlanService.create(workoutPlanCreateForm)
    @GetMapping("/{identifier}")
    fun findByIdentifier(@PathVariable identifier: UUID) = workoutPlanService.findByIdentifier(identifier)
    @GetMapping("/user/{identifier}")
    fun findActiveByUserIdentifier(@PathVariable identifier: UUID) = workoutPlanService.findActiveByUserIdentifier(identifier)
    @DeleteMapping("/delete/{identifier}")
    fun delete(@PathVariable identifier: UUID) = workoutPlanService.delete(identifier)
    @DeleteMapping("/{identifier}")
    fun deactivate(@PathVariable identifier: UUID) = workoutPlanService.deactivate(identifier)
}