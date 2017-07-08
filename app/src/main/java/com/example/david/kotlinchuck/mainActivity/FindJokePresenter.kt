package com.example.david.kotlinchuck.mainActivity

import com.example.david.kotlinchuck.mainActivity.event.FindJokeEvent

/**
 * Created by david on 28/6/17.
 */
interface FindJokePresenter {
    fun onCreate()
    fun onDestroy()
    fun findJoke(name: String, lastname: String)

    fun onEventMainThread(event: FindJokeEvent)
}
