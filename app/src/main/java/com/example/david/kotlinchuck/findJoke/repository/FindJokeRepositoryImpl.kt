package com.example.david.kotlinchuck.findJoke.repository

import android.util.Log
import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.api.ChuckClient
import com.example.david.kotlinchuck.api.RandomJokeResponse
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.event.FindJokeEvent
import com.example.david.kotlinchuck.findJoke.event.SaveJokeEvent
import com.example.david.kotlinchuck.lib.base.EventBus
import com.vicpin.krealmextensions.save
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by david on 28/6/17.
 */
class FindJokeRepositoryImpl : FindJokeRepository {

    @Inject
    lateinit var client: ChuckClient

    @Inject
    lateinit var eventBus: EventBus

    constructor() {
        MyApp.repositoryComponent().inject(this)
    }

    override fun findJoke(name: String, lastName: String) {

        client.callToChuck().getRandomWithName(name, lastName).enqueue()
    }

    override fun saveJoke(joke: Joke) {
        try {
            joke.save()
            successSaveJoke()
        } catch (e: Exception){
            Log.d("Error", e.toString())
            errorSaveJoke()
        }
    }

    private fun successSaveJoke(){
        postSaveJoke(false)
    }

    private fun errorSaveJoke() {
        postSaveJoke(true)
    }

    private fun successFindJoke(joke: Joke){
        postFindJoke(joke, false)
    }

    private fun errorFindJoke(){
        postFindJoke(null, true)
    }

    private fun postFindJoke(joke: Joke?, error: Boolean){

        val event: FindJokeEvent = FindJokeEvent()

        if(!error){
            event.type = FindJokeEvent.onSuccess
            event.joke = joke
        } else {
            event.type = FindJokeEvent.onError
        }

        eventBus.post(event)
    }

    private fun postSaveJoke(error: Boolean){
        val event: SaveJokeEvent = SaveJokeEvent()

        if(!error){
            event.type = SaveJokeEvent.onSuccess
            event.message = "Exito"
        } else {
            event.type = SaveJokeEvent.onError
            event.message = "Error"
        }

        eventBus.post(event)
    }

    private fun Call<RandomJokeResponse>.enqueue() {
        enqueue(object: Callback<RandomJokeResponse>{
            override fun onResponse(call: Call<RandomJokeResponse>?, response: Response<RandomJokeResponse>?) {
                successFindJoke(response?.body()!!.value)
            }

            override fun onFailure(call: Call<RandomJokeResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
                errorFindJoke()
            }
        })
    }

}