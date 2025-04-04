package com.marketplace.application.core.exceptions

class ParameterNullException(override val message: String): RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 2L
    }
}