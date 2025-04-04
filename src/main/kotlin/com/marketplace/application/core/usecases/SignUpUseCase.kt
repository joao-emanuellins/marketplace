package com.marketplace.application.core.usecases

import com.marketplace.application.core.domain.User
import com.marketplace.application.core.exceptions.ParameterNullException
import com.marketplace.application.core.exceptions.UserAlreadyExistsException
import com.marketplace.application.ports.inputs.SignUpInputBound
import com.marketplace.application.ports.outputs.EncryptOutputBound
import com.marketplace.application.ports.outputs.UserOutputBound

class SignUpUseCase(
    private val userOutputBound: UserOutputBound, private val encryptOutputBound: EncryptOutputBound
) : SignUpInputBound {

    override fun invoke(user: User): User {
        if (userOutputBound.findByEmail(user.email.value) != null) {
            throw UserAlreadyExistsException("User with email ${user.email.value} already exists")
        }

        val encryptedPassword =
            encryptOutputBound.encrypt(user.password ?: throw ParameterNullException("Password cannot be null"))
        val newUser = user.copy(passwordHash = encryptedPassword)
        return userOutputBound.save(newUser)
    }
}