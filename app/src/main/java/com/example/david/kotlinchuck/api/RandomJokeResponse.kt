package com.example.david.kotlinchuck.api

import com.google.gson.annotations.SerializedName

/**
 * Created by david on 30/6/17.
 */
class RandomJokeResponse(@SerializedName("type") val type: String,
                         @SerializedName("value") val value: String) {
}