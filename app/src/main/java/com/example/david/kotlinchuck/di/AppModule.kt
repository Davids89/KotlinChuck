package com.example.david.kotlinchuck.di

import android.arch.persistence.room.Room
import android.content.Context
import android.support.annotation.NonNull
import com.example.david.kotlinchuck.database.AppDatabase
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
}