package com.marketplace.adapters.outputs.respositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
    @ManyToOne @JoinColumn(name = "user_id", nullable = false) val user: UserEntity,
    @Column(name = "total_amount", nullable = false) val totalAmount: BigDecimal,
    @Enumerated(EnumType.STRING) @Column(name = "status", nullable = false) val status: OrderStatus,
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    ) val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false) val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    enum class OrderStatus {
        PENDING, PAID, SHIPPED, DELIVERED, CANCELLED
    }
}
