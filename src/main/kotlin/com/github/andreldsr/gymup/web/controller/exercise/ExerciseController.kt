package com.github.andreldsr.gymup.web.controller.exercise

import com.github.andreldsr.gymup.domain.exercise.form.ExerciseCreateForm
import com.github.andreldsr.gymup.domain.exercise.form.ExtraCreateForm
import com.github.andreldsr.gymup.service.ExerciseService
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

@RestController("Exercise")
@RequestMapping("/exercise")
class ExerciseController(private val exerciseService: ExerciseService) {

    @GetMapping
    @Operation(tags = ["Exercise"], description = "Find all exercises")
    fun findAll() = exerciseService.findAll()

    @GetMapping("/{identifier}")
    @Operation(tags = ["Exercise"], description = "Find exercise by identifier")
    fun findByIdentifier(@PathVariable identifier: UUID) = exerciseService.findByIdentifier(identifier)

    @GetMapping("/group/{identifier}")
    @Operation(tags = ["Exercise"], description = "Find all exercises by muscle group identifier")
    fun findByMuscleGroupIdentifier(@PathVariable identifier: UUID) = exerciseService.findByMuscleGroup(identifier)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(tags = ["Exercise"], description = "Create new exercise")
    fun create(@RequestBody form: ExerciseCreateForm) = exerciseService.create(form)

    @DeleteMapping("/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = ["Exercise"], description = "Delete exercise")
    fun delete(@PathVariable identifier: UUID) = exerciseService.delete(identifier)

    @PostMapping("/extra")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(tags = ["Exercise extras"], description = "Create new exercise")
    fun addExtra(@RequestBody form: ExtraCreateForm) = exerciseService.addExtra(form)

    @DeleteMapping("/extra/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = ["Exercise extras"], description = "Delete exercise")
    fun removeExtra(@PathVariable identifier: UUID) = exerciseService.removeExtra(identifier)
}
