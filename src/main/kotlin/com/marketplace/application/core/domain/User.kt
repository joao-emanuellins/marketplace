package com.marketplace.application.core.domain

import com.marketplace.application.core.exceptions.InvalidEmailFormatException
import java.time.LocalDateTime

data class User(
    val id: Int? = null,
    val name: String,
    val email: Email,
    val password: String? = null,
    val passwordHash: String? = null,
    val role: Role,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
) {
    data class Email(val value: String) {
        init {
            require(value.contains("@") && value.contains(".")) { InvalidEmailFormatException("Invalid email format") }
        }
    }

    enum class Role {
        BUYER, SELLER, ADMIN
    }
}
