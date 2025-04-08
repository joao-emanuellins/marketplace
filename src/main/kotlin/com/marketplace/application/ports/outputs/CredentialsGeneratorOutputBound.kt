package com.marketplace.application.ports.outputs

import com.marketplace.application.core.domain.User

interface CredentialsGeneratorOutputBound {

    fun generateAccessToken(user: User): User.AccessInfos

}