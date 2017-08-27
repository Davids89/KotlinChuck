package com.example.david.kotlinchuck.favoriteJokes.presenter

import com.example.david.kotlinchuck.favoriteJokes.event.DeleteEvent
import com.example.david.kotlinchuck.favoriteJokes.event.FavoriteEvent

/**
 * Created by david on 10/7/17.
 */
interface FavoriteJokesPresenter {
    fun onCreate()
    fun onDestroy()
    fun deleteJoke(text: String)

    fun onEventMainThread(event: FavoriteEvent)
    fun onDeleteEvent(event: DeleteEvent)

}