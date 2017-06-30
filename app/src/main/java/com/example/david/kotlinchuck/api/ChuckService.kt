package com.example.david.kotlinchuck.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by david on 30/6/17.
 */
interface ChuckService {
    @GET("jokes/random")
    fun getRandomWithName(@Query("firstname") firstName: String,
                          @Query("lastName") lastName: String) : Call<RandomJokeResponse>
}