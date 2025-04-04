package com.marketplace.application.core.exceptions

class InvalidEmailFormatException(override val message: String): RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}