package com.marketplace.application.core.usecases

import com.marketplace.application.core.domain.User
import com.marketplace.application.core.exceptions.ParameterNullException
import com.marketplace.application.core.exceptions.UserAlreadyExistsException
import com.marketplace.application.ports.inputs.SignUpInputBound
import com.marketplace.application.ports.outputs.EncryptOutputBound
import com.marketplace.application.ports.outputs.NotifyOutputBound
import com.marketplace.application.ports.outputs.UserOutputBound

class SignUpUseCase(
    private val userOutputBound: UserOutputBound,
    private val encryptOutputBound: EncryptOutputBound,
    private val notifyOutputBound: NotifyOutputBound
) : SignUpInputBound {

    override fun invoke(user: User): User {
        val email = user.loginInfos?.email?.value ?: throw ParameterNullException("Email cannot be null")

        if (userOutputBound.findByEmail(email) != null) {
            throw UserAlreadyExistsException("User with email ${user.loginInfos.email.value} already exists")
        }

        val encryptedPassword = encryptOutputBound.encrypt(
            user.loginInfos.password ?: throw ParameterNullException("Password cannot be null")
        )
        val newUser = user.copy(
            loginInfos = user.loginInfos.copy(
                passwordHash = encryptedPassword
            )
        )
        return userOutputBound.save(newUser).also { notifyOutputBound.notifyUserCreated(it) }
    }
}