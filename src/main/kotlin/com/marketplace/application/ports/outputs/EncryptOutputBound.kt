package com.marketplace.application.ports.outputs

interface EncryptOutputBound {

    fun encrypt(password: String): String

}