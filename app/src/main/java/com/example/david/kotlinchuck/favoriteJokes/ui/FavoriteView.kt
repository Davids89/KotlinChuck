package com.example.david.kotlinchuck.favoriteJokes.ui

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 12/8/17.
 */
interface FavoriteView {
    fun onListJokesSuccess(jokeList: List<Joke>?)
    fun onListJokesError()
}