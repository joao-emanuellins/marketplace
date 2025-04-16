package com.marketplace.configs.security

import com.marketplace.application.ports.outputs.UserOutputBound
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userOutputBound: UserOutputBound
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails =
        userOutputBound.findByEmail(username)?.mapToUserDetails() ?: throw UsernameNotFoundException("Not found!")

    fun com.marketplace.application.core.domain.User.mapToUserDetails(): UserDetails =
        User
            .builder()
            .username(this.loginInfos?.email?.value)
            .password(this.loginInfos?.password?.value)
            .roles(this.loginInfos?.role?.name)
            .build()
}