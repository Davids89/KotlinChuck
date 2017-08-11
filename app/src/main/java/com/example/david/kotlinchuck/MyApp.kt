package com.example.david.kotlinchuck

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.david.kotlinchuck.database.AppDatabase
import com.example.david.kotlinchuck.di.AppComponent
import com.example.david.kotlinchuck.di.AppModule
import com.example.david.kotlinchuck.di.DaggerAppComponent

/**
 * Created by david on 9/7/17.
 */
class MyApp: Application() {
    companion object {
        var database: AppDatabase? = null
        lateinit var context: Context
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        MyApp.database = Room.databaseBuilder(this, AppDatabase::class.java, "chuck-joke-db").build()
        context = this

        component = DaggerAppComponent.builder()
                .appModule(AppModule(context))
                .build()
    }
}