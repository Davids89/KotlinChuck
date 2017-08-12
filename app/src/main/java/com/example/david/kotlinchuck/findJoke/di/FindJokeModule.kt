package com.example.david.kotlinchuck.findJoke.di

import com.example.david.kotlinchuck.findJoke.presenter.FindJokePresenter
import com.example.david.kotlinchuck.findJoke.presenter.FindJokePresenterImpl
import com.example.david.kotlinchuck.findJoke.ui.FindJokeView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by david on 11/8/17.
 */
@Module
class FindJokeModule(var view: FindJokeView) {

    @Provides
    fun providesFindJokePresenter(): FindJokePresenter {
        return FindJokePresenterImpl(view)
    }
}