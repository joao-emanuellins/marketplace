package com.marketplace.adapters.outputs

import com.marketplace.application.core.domain.User
import com.marketplace.application.ports.outputs.CredentialsGeneratorOutputBound
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*
import org.springframework.stereotype.Component

@Component
class JwtGeneratorAdapter : CredentialsGeneratorOutputBound {

    companion object {
        private const val SECRET_KEY = "your-secret-key"
        private const val EXPIRATION_TIME = 10800000L
    }

    override fun generateAccessToken(user: User): User.AccessInfos {
        val now = Date()
        val expiration = Date(now.time + EXPIRATION_TIME)

        return User.AccessInfos(
            accessToken = Jwts
                .builder()
                .setSubject(user.id.toString())
                .claim("email", user.loginInfos?.email)
                .claim("role", user.loginInfos?.role)
                .setIssuedAt(now).setExpiration(expiration)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.toByteArray()), SignatureAlgorithm.HS256)
                .compact(),
            expiresIn = EXPIRATION_TIME
        )
    }

    override fun extractLoginInfos(token: String): User.LoginInfos = with(extractAllClaims(token)) {
        User.LoginInfos(
            email = User.LoginInfos.Email(this["email"].toString()),
            role = User.LoginInfos.Role.valueOf(this["role"].toString())
        )
    }

    override fun isValid(token: String, email: String): Boolean {
        val claims = extractAllClaims(token)
        return claims.expiration.before(Date()) && claims["email"] == email
    }

    private fun extractAllClaims(token: String): Claims =
        Jwts.parserBuilder().setSigningKey(SECRET_KEY.toByteArray()).build().parseClaimsJws(token).body
}