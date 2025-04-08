package com.marketplace.application.ports.inputs

import com.marketplace.application.core.domain.User

fun interface SignInInputBound {
    operator fun invoke(user: User): User
}
