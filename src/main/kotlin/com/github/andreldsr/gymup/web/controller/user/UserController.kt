package com.github.andreldsr.gymup.web.controller.user

import com.github.andreldsr.gymup.domain.user.form.UserCreateForm
import com.github.andreldsr.gymup.service.UserService
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
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping
    @Operation(tags = ["User"], description = "Create a new User")
    fun create(@RequestBody user: UserCreateForm) = userService.create(user)

    @GetMapping("/{identifier}")
    @Operation(tags = ["User"], description = "Find user by identifier")
    fun findByIdentifier(@PathVariable identifier: UUID) = userService.findByIdentifier(identifier)

    @GetMapping("/email/{email}")
    @Operation(tags = ["User"], description = "Find user by email")
    fun findByEmail(@PathVariable email: String) = userService.findByEmail(email)

    @DeleteMapping("/{identifier}")
    @Operation(tags = ["User"], description = "Delete user")
    fun delete(@PathVariable identifier: UUID) = userService.delete(identifier)
}
