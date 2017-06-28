package com.example.david.kotlinchuck.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by david on 28/6/17.
 */

data class Joke(
        @SerializedName("id") val id: String,
        @SerializedName("joke") val joke: String)