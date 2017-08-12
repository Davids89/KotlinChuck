package com.example.david.kotlinchuck.di

import android.content.Context
import android.support.annotation.NonNull
import com.example.david.kotlinchuck.findJoke.repository.FindJokeRepositoryImpl
import com.example.david.kotlinchuck.lib.GreenRobotEventBus
import com.example.david.kotlinchuck.lib.base.EventBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by david on 9/8/17.
 */

@Module
class AppModule(@NonNull var context: Context) {

    @Provides
    @Singleton
    fun providesContext(): Context{
        return context
    }

    @Provides
    @Singleton
    fun providesEventBus(): EventBus {
        return GreenRobotEventBus.INSTANCE
    }

    @Provides
    @Singleton
    fun providesFindJokeRepository(): FindJokeRepositoryImpl{
        return FindJokeRepositoryImpl()
    }
}