package com.marketplace.application.core.usecases

import com.marketplace.application.core.domain.User
import com.marketplace.application.core.exceptions.EntityAlreadyExistsException
import com.marketplace.application.core.exceptions.ParameterNullException
import com.marketplace.application.ports.inputs.SignUpInputBound
import com.marketplace.application.ports.outputs.EncryptOutputBound
import com.marketplace.application.ports.outputs.NotifyOutputBound
import com.marketplace.application.ports.outputs.UserOutputBound

class SignUpUseCase(
    private val userOutputBound: UserOutputBound,
    private val encryptOutputBound: EncryptOutputBound,
    private val notifyOutputBound: NotifyOutputBound
) : SignUpInputBound {

    override fun invoke(user: User): User = run {
        val email = user.loginInfos?.email?.value ?: throw ParameterNullException(message = "Email cannot be null")

        if (userOutputBound.findByEmail(email) != null) {
            throw EntityAlreadyExistsException("User with email ${user.loginInfos.email.value} already exists")
        }

        val encryptedPassword = encryptOutputBound.encrypt(
            password = user.loginInfos.password?.value
                ?: throw ParameterNullException(message = "Password cannot be null")
        )
        val newUser = user.copy(
            loginInfos = user.loginInfos.copy(
                passwordHash = encryptedPassword
            )
        )

        userOutputBound.save(newUser).also { notifyOutputBound.notifyUserCreated(user = it) }
    }
}