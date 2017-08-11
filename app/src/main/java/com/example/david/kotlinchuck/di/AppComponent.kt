package com.example.david.kotlinchuck.di

import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.mainActivity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 9/8/17.
 */
@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {
    fun inject(app: MyApp)
}