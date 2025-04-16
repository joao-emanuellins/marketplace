package com.marketplace.adapters.inputs.controllers

import com.marketplace.adapters.inputs.controllers.requests.CafeteriaCreateRequest
import jakarta.validation.Valid
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/cafeteria")
class CafeteriaController {

    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("/create")
    fun create(
        @RequestBody @Valid cafeteria: CafeteriaCreateRequest,
        @AuthenticationPrincipal authenticatedUser: UserDetails
    ) {
        // Implementation for creating a cafeteria
    }

}