package com.example.david.kotlinchuck.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.david.kotlinchuck.entities.Joke

/**
 * Created by david on 9/7/17.
 */

@Database(entities = arrayOf(Joke::class), version = 2)
abstract class AppDatabase: RoomDatabase(){
    abstract fun jokeDao(): JokeDAO
}