package com.marketplace.application.core.domain

import com.marketplace.application.core.exceptions.InvalidEmailFormatException
import java.time.LocalDateTime

data class User(
    val id: Int? = null,
    val name: String? = null,
    val loginInfos: LoginInfos? = null,
    val accessInfos: AccessInfos? = null,
    val auditInfos: AuditInfos? = null
) {
    data class LoginInfos(
        val email: Email,
        val password: Password? = null,
        val passwordHash: String? = null,
        val role: Role? = null,
    ) {
        data class Email(val value: String) {
            init {
                require(value.contains("@") && value.contains(".")) { InvalidEmailFormatException("Invalid email format") }
            }
        }

        data class Password(val value: String) {
            init {
                require(value.length >= 8) { "Password must be at least 8 characters long" }
            }
        }

        enum class Role {
            BUYER, SELLER, ADMIN
        }
    }

    data class AccessInfos(
        val accessToken: String? = null,
        val expiresIn: Long? = null,
    )

    data class AuditInfos(
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
    )


}
