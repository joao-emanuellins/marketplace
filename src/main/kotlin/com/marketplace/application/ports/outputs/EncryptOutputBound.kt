package com.marketplace.application.ports.outputs

interface EncryptOutputBound {

    fun encrypt(password: String): String

    fun verifyPassword(
        passwordHash: String,
        password: String
    ): Boolean

}