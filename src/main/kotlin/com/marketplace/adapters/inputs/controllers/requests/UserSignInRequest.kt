package com.marketplace.adapters.inputs.controllers.requests

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserSignInRequest(
    @field:NotBlank(message = "Email is required") @field:Email(message = "Email is invalid") val email: String,
    @field:NotBlank(message = "Password is required") val password: String,
)
