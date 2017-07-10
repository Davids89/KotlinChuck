package com.example.david.kotlinchuck.mainActivity

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 28/6/17.
 */
interface FindJokeRepository {
    fun findJoke(name: String, lastName: String)
    fun saveJoke(joke: Joke)
}