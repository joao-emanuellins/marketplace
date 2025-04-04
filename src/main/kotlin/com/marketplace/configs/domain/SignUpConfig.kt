package com.marketplace.configs.domain

import com.marketplace.application.core.usecases.SignUpUseCase
import com.marketplace.application.ports.inputs.SignUpInputBound
import com.marketplace.application.ports.outputs.EncryptOutputBound
import com.marketplace.application.ports.outputs.UserOutputBound
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SignUpConfig {

    @Bean
    fun signUpUseCase(
        encryptOutputBound: EncryptOutputBound,
        userOutputBound: UserOutputBound,
    ) = SignUpUseCase(userOutputBound = userOutputBound, encryptOutputBound = encryptOutputBound)

}