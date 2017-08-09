package com.example.david.kotlinchuck.lib

import com.example.david.kotlinchuck.lib.base.EventBus

/**
 * Created by david on 29/6/17.
 */
class GreenRobotEventBus : EventBus {

    var eventBus: org.greenrobot.eventbus.EventBus = org.greenrobot.eventbus.EventBus.getDefault()

    companion object {
        var INSTANCE = GreenRobotEventBus()
    }

    override fun register(suscriber: Any) {
        this.eventBus.register(suscriber)
    }

    override fun unregister(suscriber: Any) {
        this.eventBus.unregister(suscriber)
    }

    override fun post(event: Any) {
        this.eventBus.post(event)
    }

}