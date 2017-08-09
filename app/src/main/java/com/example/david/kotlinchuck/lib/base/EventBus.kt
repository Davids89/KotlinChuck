package com.example.david.kotlinchuck.lib.base

/**
 * Created by david on 29/6/17.
 */
interface EventBus {
    fun register(suscriber: Any)
    fun unregister(suscriber: Any)
    fun post(event: Any)
}