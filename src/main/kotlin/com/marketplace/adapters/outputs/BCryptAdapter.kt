package com.marketplace.adapters.outputs

import com.marketplace.application.ports.outputs.EncryptOutputBound
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class BCryptAdapter : EncryptOutputBound {

    override fun encrypt(password: String): String = BCryptPasswordEncoder().encode(password)

}