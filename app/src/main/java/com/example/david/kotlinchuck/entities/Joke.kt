package com.example.david.kotlinchuck.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by david on 28/6/17.
 */

@Entity
data class Joke(
        @PrimaryKey(autoGenerate = true)
        val uid: Long,
        @SerializedName("id") val id: String,
        @SerializedName("joke") val joke: String)