package com.example.david.kotlinchuck.favoriteJokes.di

import com.example.david.kotlinchuck.favoriteJokes.presenter.FavoriteJokesPresenter
import com.example.david.kotlinchuck.favoriteJokes.presenter.FavoriteJokesPresenterImpl
import com.example.david.kotlinchuck.favoriteJokes.repository.FavoriteJokesRepository
import com.example.david.kotlinchuck.favoriteJokes.repository.FavoriteJokesRepositoryImpl
import com.example.david.kotlinchuck.favoriteJokes.ui.FavoriteView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by david on 12/8/17.
 */
@Module
class FavoriteModule(var view: FavoriteView) {

    @Provides
    @Singleton
    fun providesFavoritePresenter(): FavoriteJokesPresenter {
        return FavoriteJokesPresenterImpl(view)
    }

    @Provides
    @Singleton
    fun providesFavoriteRepository(): FavoriteJokesRepository{
        return FavoriteJokesRepositoryImpl()
    }
}