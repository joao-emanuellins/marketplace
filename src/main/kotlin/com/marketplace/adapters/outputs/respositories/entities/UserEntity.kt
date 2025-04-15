package com.marketplace.adapters.outputs.respositories.entities

import com.marketplace.application.core.domain.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
    @Column(name = "name", nullable = false) val name: String,
    @Column(name = "email", nullable = false, unique = true) val email: String,
    @Column(name = "password_hash", nullable = false) val passwordHash: String,
    @Enumerated(EnumType.STRING) @Column(name = "role", nullable = false) val role: Role,
    override var updatedAt: LocalDateTime
) : AuditEntity(updatedAt = updatedAt) {
    constructor(user: User) : this(
        id = user.id ?: 0,
        name = user.name!!,
        email = user.loginInfos!!.email.value,
        passwordHash = user.loginInfos.passwordHash!!,
        role = Role.valueOf(user.loginInfos.role!!.name),
        updatedAt = user.auditInfos?.updatedAt ?: LocalDateTime.now()
    )

    enum class Role {
        SELLER, BUYER, ADMIN
    }

    fun toDomain(): User {
        return User(
            id = id,
            name = name,
            loginInfos = User.LoginInfos(
                email = User.LoginInfos.Email(email),
                passwordHash = passwordHash,
                role = User.LoginInfos.Role.valueOf(role.name)
            ),
            auditInfos = User.AuditInfos(
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        )
    }
}
