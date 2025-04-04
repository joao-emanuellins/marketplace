package com.marketplace.adapters.inputs.controllers.requests

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class UserSignUpRequest(
    @field:NotBlank(message = "Name is required") val name: String,
    @field:NotBlank(message = "Email is required") @field:Email(message = "Email is invalid") val email: String,
    @field:NotBlank(message = "Password is required") val password: String,
    @field:NotBlank(message = "Role is required") @field:Pattern(
        regexp = "^(SELLER|BUYER)$",
        message = "Role must be either SELLER or BUYER"
    ) val role: String,
)
