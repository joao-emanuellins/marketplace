package com.marketplace.adapters.inputs.controllers.responses

import com.marketplace.application.core.domain.User
import com.marketplace.application.core.exceptions.ParameterNullException
import java.time.LocalDateTime

data class UserResponse(
    val id: Int,
    val name: String,
    val email: String,
    val passwordHash: String,
    val role: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    constructor(user: User) : this(
        id = user.id ?: throw ParameterNullException("User ID cannot be null"),
        name = user.name ?: throw ParameterNullException("User name cannot be null"),
        email = user.loginInfos?.email?.value ?: throw ParameterNullException("User email hash cannot be null"),
        passwordHash = user.loginInfos.passwordHash
            ?: throw ParameterNullException("User password hash cannot be null"),
        role = user.loginInfos.role?.name ?: throw ParameterNullException("User role cannot be null"),
        createdAt = user.auditInfos?.createdAt ?: throw ParameterNullException("User createdAt cannot be null"),
        updatedAt = user.auditInfos.updatedAt ?: throw ParameterNullException(
            "User updatedAt cannot be null"
        )
    )
}
