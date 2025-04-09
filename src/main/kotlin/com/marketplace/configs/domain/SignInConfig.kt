package com.marketplace.configs.domain

import com.marketplace.application.core.usecases.SignInUseCase
import com.marketplace.application.ports.outputs.CredentialsGeneratorOutputBound
import com.marketplace.application.ports.outputs.EncryptOutputBound
import com.marketplace.application.ports.outputs.UserOutputBound
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SignInConfig {

    @Bean
    fun signInUseCase(
        userOutputBound: UserOutputBound,
        encryptOutputBound: EncryptOutputBound,
        credentialsGeneratorOutputBound: CredentialsGeneratorOutputBound
    ) = SignInUseCase(
        userOutputBound = userOutputBound,
        encryptOutputBound = encryptOutputBound,
        credentialsGeneratorOutputBound = credentialsGeneratorOutputBound
    )

}