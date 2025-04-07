package com.marketplace.application.ports.outputs

import com.marketplace.application.core.domain.User

interface NotifyOutputBound {

    fun notifyUserCreated(user: User)

}