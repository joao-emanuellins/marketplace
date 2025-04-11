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
    override fun invoke(user: User): User = run {
        val email = user.loginInfos?.email?.value ?: throw ParameterNullException(message = "Email cannot be null")

        val userFound = userOutputBound.findByEmail(email = email)
            ?: throw InvalidCredentialsException(message = "User and/or email are invalid(s)")

        val isPasswordValid = encryptOutputBound.verifyPassword(
            passwordHash = userFound.loginInfos?.passwordHash
                ?: throw ParameterNullException(message = "Password hash cannot be null"),
            password = user.loginInfos.password?.value
                ?: throw EntityNotFoundException(message = "Password cannot be null")
        )

        if (!isPasswordValid) {
            throw InvalidCredentialsException(message = "User and/or email are invalid(s)")
        }

        userFound.copy(
            accessInfos = credentialsGeneratorOutputBound.generateAccessToken(user = userFound)
        )
    }
}