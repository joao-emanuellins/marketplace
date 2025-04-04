package com.marketplace.application.ports.outputs

import com.marketplace.application.core.domain.User

interface UserOutputBound {

    fun findByEmail(email: String): User?
    fun save(user: User): User

}