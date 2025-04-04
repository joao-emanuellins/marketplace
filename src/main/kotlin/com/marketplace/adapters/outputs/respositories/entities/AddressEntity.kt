package com.marketplace.adapters.outputs.respositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "addresses")
data class AddressEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
    @ManyToOne @JoinColumn(name = "user_id", nullable = false) val user: UserEntity,
    @Column(name = "street", nullable = false) val street: String,
    @Column(name = "city", nullable = false) val city: String,
    @Column(name = "state", nullable = false) val state: String,
    @Column(name = "country", nullable = false) val country: String,
    @Column(name = "zip_code", nullable = false) val zipCode: String,
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    ) val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false) val updatedAt: LocalDateTime = LocalDateTime.now()
)
