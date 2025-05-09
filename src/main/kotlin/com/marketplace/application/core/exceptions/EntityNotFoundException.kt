package com.marketplace.application.core.exceptions

class EntityNotFoundException(override val message: String) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 4L
    }
}