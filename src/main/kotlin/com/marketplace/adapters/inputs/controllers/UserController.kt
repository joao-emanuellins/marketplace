package com.marketplace.adapters.inputs.controllers

import com.marketplace.adapters.inputs.controllers.requests.UserSignUpRequest
import com.marketplace.adapters.inputs.controllers.responses.UserResponse
import com.marketplace.application.core.domain.User
import com.marketplace.application.ports.inputs.SignUpInputBound
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val signUpUser: SignUpInputBound
) {
    @PostMapping("/sign-up")
    fun singUp(@RequestBody @Valid userRequest: UserSignUpRequest) = runCatching {
        val user = with(userRequest) {
            User(
                name = name, loginInfos = User.LoginInfos(
                    email = User.LoginInfos.Email(email),
                    password = User.LoginInfos.Password(password),
                    role = User.LoginInfos.Role.valueOf(role)
                )
            )
        }

        val userCreated = signUpUser(user)
        UserResponse(userCreated)
    }.fold(onSuccess = {
        ResponseEntity.status(HttpStatus.CREATED).body(it)
    }, onFailure = {
        ResponseEntity.badRequest().body(it.message)
    })

}