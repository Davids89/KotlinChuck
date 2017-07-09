package com.example.david.kotlinchuck

import android.app.Application
import android.arch.persistence.room.Room
import com.example.david.kotlinchuck.database.AppDatabase

/**
 * Created by david on 9/7/17.
 */
class MyApp: Application() {
    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        MyApp.database = Room.databaseBuilder(this, AppDatabase::class.java, "chuck-joke-db").build()
    }
}