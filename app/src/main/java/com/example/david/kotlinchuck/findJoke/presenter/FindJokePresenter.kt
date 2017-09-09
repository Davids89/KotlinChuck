package com.example.david.kotlinchuck.findJoke.presenter

import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.event.FindJokeEvent
import com.example.david.kotlinchuck.findJoke.event.SaveJokeEvent

/**
 * Created by david on 28/6/17.
 */
interface FindJokePresenter {
    fun onCreate()
    fun onDestroy()
    fun findJoke()
    fun saveJoke(joke: Joke)

    fun onEventMainThread(event: FindJokeEvent)
    fun onSaveJokeEvent(event: SaveJokeEvent)
}
