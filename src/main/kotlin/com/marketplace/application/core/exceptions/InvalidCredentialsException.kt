package com.marketplace.application.core.exceptions

class InvalidCredentialsException(override val message: String) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 5L
    }
}