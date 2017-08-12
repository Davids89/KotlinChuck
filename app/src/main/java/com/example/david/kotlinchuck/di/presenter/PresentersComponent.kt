package com.example.david.kotlinchuck.di.presenter

import com.example.david.kotlinchuck.findJoke.presenter.FindJokePresenterImpl
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 12/8/17.
 */
@Component(modules = arrayOf(PresentersModule::class))
@Singleton
interface PresentersComponent {
    fun inject(presenter: FindJokePresenterImpl)
}