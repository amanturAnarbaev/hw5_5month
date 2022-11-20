package com.example.hw5_5month

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
object Modulse {

    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences("isShow", Context.MODE_PRIVATE)
    }
}