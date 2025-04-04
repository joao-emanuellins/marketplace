package com.marketplace.adapters.outputs

import com.marketplace.adapters.outputs.respositories.UserRepository
import com.marketplace.adapters.outputs.respositories.entities.UserEntity
import com.marketplace.application.core.domain.User
import com.marketplace.application.ports.outputs.UserOutputBound
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(private val userRepository: UserRepository) : UserOutputBound {

    override fun findByEmail(email: String) = userRepository.findByEmail(email)?.toDomain()

    override fun save(user: User) = userRepository.save(UserEntity(user)).toDomain()
}