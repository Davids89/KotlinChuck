package com.example.david.kotlinchuck

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.david.kotlinchuck.database.AppDatabase
import com.example.david.kotlinchuck.di.*
import com.example.david.kotlinchuck.findJoke.di.DaggerFindJokeComponent
import com.example.david.kotlinchuck.findJoke.di.FindJokeComponent
import com.example.david.kotlinchuck.findJoke.di.FindJokeModule
import com.example.david.kotlinchuck.findJoke.ui.FindJokeView
import com.example.david.kotlinchuck.mainActivity.MainActivity
import com.example.david.kotlinchuck.mainActivity.di.DaggerMainActivityComponent
import com.example.david.kotlinchuck.mainActivity.di.MainActivityComponent
import com.example.david.kotlinchuck.mainActivity.di.MainActivityModule

/**
 * Created by david on 9/7/17.
 */
class MyApp: Application() {
    companion object {
        var database: AppDatabase? = null
        lateinit var context: Context
        lateinit var component: MyAppComponent

        fun mainActivityComponent(mainActivity: MainActivity): MainActivityComponent{
            return DaggerMainActivityComponent.builder()
                    .mainActivityModule(MainActivityModule(mainActivity))
                    .build()
        }

        fun searchFragmentComponent(view: FindJokeView): FindJokeComponent{
            return DaggerFindJokeComponent.builder()
                    .findJokeModule(FindJokeModule(view))
                    .build()
        }

        fun presenterComponent(): PresentersComponent{
            return DaggerPresentersComponent.builder()
                    .presentersModule(PresentersModule())
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        MyApp.database = Room.databaseBuilder(this, AppDatabase::class.java, "chuck-joke-db").build()
        context = this

        component = DaggerMyAppComponent.builder()
                .myAppModule(MyAppModule(context))
                .build()
    }
}