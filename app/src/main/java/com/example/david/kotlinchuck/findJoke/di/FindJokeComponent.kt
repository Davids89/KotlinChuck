package com.example.david.kotlinchuck.findJoke.di

import com.example.david.kotlinchuck.findJoke.ui.SearchFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 11/8/17.
 */
@Component(modules = arrayOf(FindJokeModule::class))
@Singleton
interface FindJokeComponent {
    fun inject(searchFragment: SearchFragment)
}