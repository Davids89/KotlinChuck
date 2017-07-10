package com.example.david.kotlinchuck.findJoke

import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.api.ChuckClient
import com.example.david.kotlinchuck.api.RandomJokeResponse
import com.example.david.kotlinchuck.entities.Joke
import com.example.david.kotlinchuck.findJoke.event.FindJokeEvent
import com.example.david.kotlinchuck.lib.EventBus
import com.example.david.kotlinchuck.lib.GreenRobotEventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by david on 28/6/17.
 */
class FindJokeRepositoryImpl: FindJokeRepository {

    private val client: ChuckClient = ChuckClient()
    val eventBus: EventBus = GreenRobotEventBus.INSTANCE

    override fun findJoke(name: String, lastName: String) {

        client.callToChuck().getRandomWithName(name, lastName).enqueue()
    }

    override fun saveJoke(joke: Joke) {
        MyApp.database?.jokeDao()?.insertJoke(joke)
    }

    private fun success(joke: Joke){
        post(joke, false)
    }

    private fun error(){
        post(null, true)
    }

    private fun post(joke: Joke?, error: Boolean){

        var event: FindJokeEvent = FindJokeEvent()

        if(!error){
            event.type = FindJokeEvent.onSuccess
            event.joke = joke
        } else {
            event.type = FindJokeEvent.onError
        }

        eventBus.post(event)
    }

    private fun Call<RandomJokeResponse>.enqueue() {
        enqueue(object: Callback<RandomJokeResponse>{
            override fun onResponse(call: Call<RandomJokeResponse>?, response: Response<RandomJokeResponse>?) {
                success(response?.body()!!.value)
            }

            override fun onFailure(call: Call<RandomJokeResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
                error()
            }
        })
    }

}