package com.example.david.kotlinchuck.favoriteJokes.event

import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 12/8/17.
 */
class FavoriteEvent {
    companion object {
        var onSuccess = 0
        var onError = 1
    }

    var jokes: List<Joke>? = arrayListOf()
    var type: Int? = null
}