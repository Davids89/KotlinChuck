package com.example.david.kotlinchuck.favoriteJokes.repository

/**
 * Created by david on 10/7/17.
 */
interface FavoriteJokesRepository {
    fun getJokes()
    fun deleteJoke(text: String)
}