package com.example.david.kotlinchuck.findJoke.event

/**
 * Created by david on 8/8/17.
 */
class SaveJokeEvent {
    companion object {
        val onSuccess = 0
        val onError = 1
    }

    var message: String = String()
    var type: Int? = null
}