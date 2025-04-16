package com.marketplace.application.ports.outputs

import com.marketplace.application.core.domain.User

interface CredentialsGeneratorOutputBound {

    fun generateAccessToken(user: User): User.AccessInfos

    fun extractLoginInfos(token: String): User.LoginInfos

    fun isValid(token: String, email: String): Boolean

}