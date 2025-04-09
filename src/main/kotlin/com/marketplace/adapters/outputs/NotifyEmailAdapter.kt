package com.marketplace.adapters.outputs

import com.marketplace.application.core.domain.User
import com.marketplace.application.ports.outputs.NotifyOutputBound
import org.springframework.stereotype.Component

@Component
class NotifyEmailAdapter : NotifyOutputBound {
    override fun notifyUserCreated(user: User) {
        println("Email sent to ${user.loginInfos?.email?.value} with subject 'Welcome ${user.name}'")
    }
}