package com.fabianospdev.petscare.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.fabianospdev.petscare.core.helpers.DefaultRetryController
import com.fabianospdev.petscare.core.helpers.RetryController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideRetryController(): RetryController {
        return DefaultRetryController(maxRetries = 3)
    }
}
