package com.marketplace.adapters.inputs.controllers.responses

import com.marketplace.application.core.domain.User
import com.marketplace.application.core.exceptions.ParameterNullException

data class JwtTokenResponse(
    val accessToken: String, val expiresIn: Long
) {
    constructor(user: User) : this(
        accessToken = user.accessInfos?.accessToken ?: throw ParameterNullException("Access token cannot be null"),
        expiresIn = user.accessInfos.expiresIn ?: throw ParameterNullException("Expires in cannot be null")
    )
}
