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
@Table(name = "products")
data class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
    @ManyToOne @JoinColumn(name = "store_id", nullable = false) val store: StoreEntity,
    @Column(name = "name", nullable = false) val name: String,
    @Column(name = "description") val description: String?,
    @Column(name = "price", nullable = false) val price: BigDecimal,
    @Column(name = "stock_quantity", nullable = false) val stockQuantity: Int,
    @Column(
        name = "created_at", nullable = false, updatable = false
    ) val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = false) val updatedAt: LocalDateTime = LocalDateTime.now()
)
