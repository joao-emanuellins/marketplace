package com.marketplace.adapters.inputs.controllers.requests

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class CafeteriaCreateRequest(
    @field:NotBlank(message = "Name must not be blank") val name: String,
    @field:NotBlank(message = "Document number must not be blank") @field:Size(
        max = 18, message = "Document number must not exceed 18 characters"
    ) val documentNumber: String,
    @field:NotBlank(message = "Document type must not be blank") @field:Pattern(
        regexp = "CPF|CNPJ", message = "Document type must be either 'CPF' or 'CNPJ'"
    ) val documentType: String,
    @field:NotBlank(message = "Phone must not be blank") @field:Size(
        max = 15, message = "Phone must not exceed 15 characters"
    ) val phone: String,
    @field:NotBlank(message = "Address must not be blank") val address: String,
    @field:NotBlank(message = "Description must not be blank") val description: String
)