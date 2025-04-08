package com.marketplace.adapters.outputs

import com.marketplace.application.core.domain.User
import com.marketplace.application.ports.outputs.CredentialsGeneratorOutputBound
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*

class JwtGeneratorAdapter : CredentialsGeneratorOutputBound {

    companion object {
        private const val SECRET_KEY = "your-secret-key"
        private const val EXPIRATION_TIME = 10800000L
    }

    override fun generateAccessToken(user: User): User {
        val now = Date()
        val expiration = Date(now.time + EXPIRATION_TIME)

        return user.copy(
            accessToken = Jwts.builder()
                .setSubject(user.id.toString())
                .claim("email", user.email)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.toByteArray()), SignatureAlgorithm.HS256)
                .compact(),
            expiresIn = EXPIRATION_TIME
        )
    }
}