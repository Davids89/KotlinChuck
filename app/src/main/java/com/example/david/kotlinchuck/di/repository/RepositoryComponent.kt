package com.example.david.kotlinchuck.di.repository

import com.example.david.kotlinchuck.favoriteJokes.repository.FavoriteJokesRepositoryImpl
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepositoryImpl
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 12/8/17.
 */
@Component(modules = arrayOf(RepositoryModule::class))
@Singleton
interface RepositoryComponent {
    fun inject(repository: FindJokeRepositoryImpl)
    fun inject(repository: FavoriteJokesRepositoryImpl)
}