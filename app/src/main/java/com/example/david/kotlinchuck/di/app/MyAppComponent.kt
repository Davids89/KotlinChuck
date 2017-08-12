package com.example.david.kotlinchuck.di.app

import com.example.david.kotlinchuck.MyApp
import com.example.david.kotlinchuck.findJoke.presenter.FindJokePresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 9/8/17.
 */
@Component(modules = arrayOf(MyAppModule::class))
@Singleton
interface MyAppComponent {
    fun inject(app: MyApp)
    fun inject(findJokePresenter: FindJokePresenter)
}