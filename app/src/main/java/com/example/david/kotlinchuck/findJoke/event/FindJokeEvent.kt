package com.example.david.kotlinchuck.findJoke.event

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 28/6/17.
 */

class FindJokeEvent(){
    val onSuccess = 0
    val onError = 1

    private var type: Int? = null
    private var joke: Joke? = null
}