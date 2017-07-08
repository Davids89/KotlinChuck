package com.example.david.kotlinchuck.mainActivity.ui

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 28/6/17.
 */
interface FindJokeView {
    fun jokeSuccess(joke: Joke)
    fun jokeError()
}