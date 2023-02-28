package com.github.andreldsr.gymup.web.controller.musclegroup

import com.github.andreldsr.gymup.domain.musclegroup.form.MuscleGroupCreateForm
import com.github.andreldsr.gymup.service.MuscleGroupService
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

@RestController("Muscle Group")
@RequestMapping("/muscleGroup")
class MuscleGroupController(private val muscleGroupService: MuscleGroupService) {

    @GetMapping
    @Operation(tags = ["Muscle Group"], description = "Find all muscle groups")
    fun findAll() = muscleGroupService.findAll()

    @PostMapping
    @Operation(tags = ["Muscle Group"], description = "Create new muscle group")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody form: MuscleGroupCreateForm) = muscleGroupService.create(form)

    @DeleteMapping("/{identifier}")
    @Operation(tags = ["Muscle Group"], description = "Delete muscle group")
    fun delete(@PathVariable identifier: UUID) = muscleGroupService.delete(identifier)
}
