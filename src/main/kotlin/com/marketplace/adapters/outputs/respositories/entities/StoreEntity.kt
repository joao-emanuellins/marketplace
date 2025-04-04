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
@Table(name = "stores")
data class StoreEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
    @ManyToOne @JoinColumn(name = "owner_id", nullable = false) val owner: UserEntity,
    @Column(name = "name", nullable = false) val name: String,
    @Column(name = "description") val description: String?,
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    ) val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false) val updatedAt: LocalDateTime = LocalDateTime.now()
)
