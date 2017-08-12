package com.example.david.kotlinchuck.mainActivity.di

import com.example.david.kotlinchuck.mainActivity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 11/8/17.
 */

@Component(modules = arrayOf(MainActivityModule::class))
@Singleton
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}