package com.example.david.kotlinchuck.findJoke.ui

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 28/6/17.
 */
interface FindJokeView {
    fun jokeSuccess(joke: Joke)
    fun jokeError()
    fun showSaveJoke()
    fun saveJokeSuccess(message: String)
    fun saveJokeError(message: String)
}