package com.example.david.kotlinchuck.favoriteJokes.repository

import android.util.Log
import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.lib.base.EventBus
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
        launch(CommonPool){
            try {
                jokes = Joke().queryAll()
                success(jokes)
            }catch (e: Exception){
                Log.d("Error", e.toString())
                error()
            }
        }
    }

    fun success(jokes: List<Joke>?){
        post(jokes, false)
    }

    fun error(){
        post(null, true)
    }

    fun post(jokes: List<Joke>?, error: Boolean){

    }
}