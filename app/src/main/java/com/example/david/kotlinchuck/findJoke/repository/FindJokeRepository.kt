package com.example.david.kotlinchuck.findJoke.repository

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 28/6/17.
 */
interface FindJokeRepository {
    fun findJoke()
    fun saveJoke(joke: Joke)
}