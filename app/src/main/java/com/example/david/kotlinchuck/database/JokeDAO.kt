package com.example.david.kotlinchuck.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 9/7/17.
 */

@Dao
interface JokeDAO {

    @Query("SELECT * FROM joke")
    fun getAllJokes(): List<Joke>

    @Insert
    fun insertJoke(joke: Joke)
}