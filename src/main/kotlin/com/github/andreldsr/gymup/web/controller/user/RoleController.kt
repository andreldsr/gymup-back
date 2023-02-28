package com.github.andreldsr.gymup.web.controller.user

import com.github.andreldsr.gymup.domain.user.form.RoleCreateForm
import com.github.andreldsr.gymup.service.RoleService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/role")
class RoleController(private val roleService: RoleService) {
    @PostMapping
    @Operation(tags = ["Role"], description = "Create new role")
    fun create(@RequestBody role: RoleCreateForm) = roleService.create(role)

    @GetMapping
    fun findAll() = roleService.findAll()

    @GetMapping("/{name}")
    fun findByName(@PathVariable name: String) = roleService.findByName(name)

    @GetMapping("/user/{identifier}")
    fun findByUserIdentifier(@PathVariable identifier: UUID) = roleService.findByUserIdentifier(identifier)

    @DeleteMapping("/{identifier}")
    fun delete(@PathVariable identifier: UUID) = roleService.delete(identifier)
}
