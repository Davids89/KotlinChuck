package com.example.david.kotlinchuck.di.presenter

import com.example.david.kotlinchuck.favoriteJokes.repository.FavoriteJokesRepository
import com.example.david.kotlinchuck.favoriteJokes.repository.FavoriteJokesRepositoryImpl
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepository
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepositoryImpl
import com.example.david.kotlinchuck.lib.GreenRobotEventBus
import com.example.david.kotlinchuck.lib.base.EventBus
import dagger.Module
import dagger.Provides

/**
 * Created by david on 12/8/17.
 */

@Module
class PresentersModule {

    @Provides
    fun providesEventBus(): EventBus {
        return GreenRobotEventBus.INSTANCE
    }

    @Provides
    fun providesFindJokeRepository(): FindJokeRepository {
        return FindJokeRepositoryImpl()
    }

    @Provides
    fun providesFavoriteRepository(): FavoriteJokesRepository{
        return FavoriteJokesRepositoryImpl()
    }
}