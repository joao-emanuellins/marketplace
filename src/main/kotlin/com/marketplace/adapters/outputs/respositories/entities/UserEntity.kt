package com.marketplace.adapters.outputs.respositories.entities

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
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    ) val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false) val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    enum class Role {
        BUYER, SELLER, ADMIN
    }
}
