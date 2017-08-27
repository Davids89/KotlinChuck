package com.example.david.kotlinchuck.favoriteJokes.repository

import android.util.Log
import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.favoriteJokes.event.DeleteEvent
import com.example.david.kotlinchuck.favoriteJokes.event.FavoriteEvent
import com.example.david.kotlinchuck.lib.base.EventBus
import com.vicpin.krealmextensions.delete
import com.vicpin.krealmextensions.queryAll
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

/**
 * Created by david on 10/7/17.
 */
class FavoriteJokesRepositoryImpl: FavoriteJokesRepository {

    @Inject
    lateinit var eventBus: EventBus

    var jokes: List<Joke>? = null

    constructor(){
        MyApp.repositoryComponent().inject(this)
    }

    override fun getJokes() {
        try {
            jokes = Joke().queryAll()
            success(jokes)
        }catch (e: Exception){
            Log.d("Error", e.toString())
            error()
        }
    }

    override fun deleteJoke(text: String) {
        try{
            Joke().delete { query -> query.equalTo("joke", text) }
            val jokes: List<Joke> = Joke().queryAll()
            successDelete(jokes)
        }catch (e: Exception){
            errorDelete()
        }

    }

    private fun success(jokes: List<Joke>?){
        post(jokes, false)
    }

    private fun successDelete(jokes: List<Joke>){
        postDelete(jokes, false)
    }

    private fun error(){
        post(null, true)
    }

    private fun errorDelete(){
        postDelete(null, true)
    }

    private fun post(jokes: List<Joke>?, error: Boolean){
        val event: FavoriteEvent = FavoriteEvent()

        if(!error){
            event.type = FavoriteEvent.onSuccess
            event.jokes = jokes
        } else {
            event.type = FavoriteEvent.onError
        }

        eventBus.post(event)
    }

    private fun postDelete(jokes: List<Joke>?, error: Boolean){

        val event: DeleteEvent = DeleteEvent()

        if(!error){
            event.type = DeleteEvent.onSuccess
            event.jokes = jokes
        } else {
            event.type = DeleteEvent.onError
        }

        eventBus.post(event)
    }
}