package com.example.david.kotlinchuck.mainActivity.di

import android.support.v4.app.FragmentManager
import com.example.david.kotlinchuck.mainActivity.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by david on 9/8/17.
 */
@Module
class MainActivityModule(var mainActivity: MainActivity) {

    @Provides
    fun providesFragmentManager(): FragmentManager{
        return mainActivity.supportFragmentManager
    }
}