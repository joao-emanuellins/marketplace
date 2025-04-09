package com.marketplace.application.core.exceptions

class EntityAlreadyExistsException(override val message: String) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 3L
    }
}