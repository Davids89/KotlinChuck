package com.example.david.kotlinchuck.favoriteJokes.event

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 27/8/17.
 */
class DeleteEvent {
    companion object {
        val onSuccess: Int = 0
        val onError: Int = 1
    }

    var type: Int = 0
    var jokes: List<Joke>? = null
}