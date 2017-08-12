package com.example.david.kotlinchuck.di.repository

import com.example.david.kotlinchuck.api.ChuckClient
import com.example.david.kotlinchuck.lib.GreenRobotEventBus
import com.example.david.kotlinchuck.lib.base.EventBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by david on 12/8/17.
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesChuckClient(): ChuckClient{
        return ChuckClient()
    }

    @Provides
    @Singleton
    fun providesEventBus(): EventBus{
        return GreenRobotEventBus.INSTANCE
    }
}