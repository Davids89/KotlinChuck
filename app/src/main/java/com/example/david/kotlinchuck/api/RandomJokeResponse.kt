package com.example.david.kotlinchuck.api

import com.example.david.kotlinchuck.entities.Joke
import com.google.gson.annotations.SerializedName

/**
 * Created by david on 30/6/17.
 */
data class RandomJokeResponse(@SerializedName("type") var type: String,
                              @SerializedName("value") var value: Joke)