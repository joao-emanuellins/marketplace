package com.marketplace.application.core.exceptions

class UserAlreadyExistsException(override val message: String): RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 3L
    }
}