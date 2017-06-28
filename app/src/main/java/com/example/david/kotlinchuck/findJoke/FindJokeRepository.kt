package com.example.david.kotlinchuck.findJoke

/**
 * Created by david on 28/6/17.
 */
interface FindJokeRepository {
    fun findJoke(name: String, lastName: String)
}