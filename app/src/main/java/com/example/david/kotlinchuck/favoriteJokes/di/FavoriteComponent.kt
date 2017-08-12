package com.example.david.kotlinchuck.favoriteJokes.di

import com.example.david.kotlinchuck.favoriteJokes.ui.FavoriteFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 12/8/17.
 */
@Component(modules = arrayOf(FavoriteModule::class))
@Singleton
interface FavoriteComponent {
    fun inject(favoriteFragment: FavoriteFragment)
}