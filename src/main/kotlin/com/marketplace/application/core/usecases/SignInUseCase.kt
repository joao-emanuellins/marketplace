package com.marketplace.application.core.usecases

import com.marketplace.application.core.domain.User
import com.marketplace.application.core.exceptions.EntityNotFoundException
import com.marketplace.application.core.exceptions.InvalidCredentialsException
import com.marketplace.application.core.exceptions.ParameterNullException
import com.marketplace.application.ports.inputs.SignInInputBound
import com.marketplace.application.ports.outputs.CredentialsGeneratorOutputBound
import com.marketplace.application.ports.outputs.EncryptOutputBound
import com.marketplace.application.ports.outputs.UserOutputBound

class SignInUseCase(
    private val userOutputBound: UserOutputBound,
    private val encryptOutputBound: EncryptOutputBound,
    private val credentialsGeneratorOutputBound: CredentialsGeneratorOutputBound
) : SignInInputBound {
    override fun invoke(user: User): User {
        val userFound = userOutputBound.findByEmail(user.email.value)
            ?: throw InvalidCredentialsException("User and/or email are invalid(s)")

        val isPasswordValid = encryptOutputBound.verifyPassword(
            userFound.passwordHash ?: throw ParameterNullException("Password hash cannot be null"),
            user.password ?: throw EntityNotFoundException("Password cannot be null")
        )

        if (!isPasswordValid) {
            throw InvalidCredentialsException("User and/or email are invalid(s)")
        }

        return credentialsGeneratorOutputBound.generateAccessToken(userFound)
    }
}