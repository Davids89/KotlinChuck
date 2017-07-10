package com.example.david.kotlinchuck.findJoke.event

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 28/6/17.
 */

class FindJokeEvent{

    companion object {
        val onSuccess = 0
        val onError = 1
    }

    var type: Int? = null
    var joke: Joke? = null
}