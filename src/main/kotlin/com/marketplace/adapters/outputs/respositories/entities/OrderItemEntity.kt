package com.marketplace.adapters.outputs.respositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "order_items")
data class OrderItemEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
    @ManyToOne @JoinColumn(name = "order_id", nullable = false) val order: OrderEntity,
    @ManyToOne @JoinColumn(name = "product_id", nullable = false) val product: ProductEntity,
    @Column(name = "quantity", nullable = false) val quantity: Int,
    @Column(name = "price", nullable = false) val price: BigDecimal,
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    ) val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false) val updatedAt: LocalDateTime = LocalDateTime.now()
)
