package com.example.david.kotlinchuck.mainActivity.di

import com.example.david.kotlinchuck.mainActivity.MainActivity
import dagger.Component

/**
 * Created by david on 11/8/17.
 */

@Component(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}