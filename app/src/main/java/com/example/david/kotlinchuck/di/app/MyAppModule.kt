package com.example.david.kotlinchuck.di.app

import android.content.Context
import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by david on 9/8/17.
 */

@Module
class MyAppModule(@NonNull var context: Context) {

    @Provides
    @Singleton
    fun providesContext(): Context{
        return context
    }
}