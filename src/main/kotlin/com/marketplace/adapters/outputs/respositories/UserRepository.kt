package com.marketplace.adapters.outputs.respositories

import com.marketplace.adapters.outputs.respositories.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Int> {
    fun findByEmail(email: String): UserEntity?
}