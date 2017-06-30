package com.example.david.kotlinchuck.findJoke

import com.example.david.kotlinchuck.api.ChuckClient
import com.example.david.kotlinchuck.api.RandomJokeResponse
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
    private val eventBus: EventBus = GreenRobotEventBus.INSTANCE

    override fun findJoke(name: String, lastName: String) {

        client.callToChuck().getRandomWithName(name, lastName).enqueue()
    }

}

private fun <T> Call<T>.enqueue() {
    enqueue(object: Callback<T>{
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            println(response?.body().toString())
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            println(t?.localizedMessage.toString())
        }
    })
}
