package com.example.app.di

import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.api.ProfileDatasource
import com.fabianospdev.petscare.data.api.SettingsDatasource
import com.fabianospdev.petscare.data.api.UserDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginDatasource {
        return retrofit.create(LoginDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserDatasource {
        return retrofit.create(UserDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileService(retrofit: Retrofit): ProfileDatasource {
        return retrofit.create(ProfileDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideSettingsService(retrofit: Retrofit): SettingsDatasource {
        return retrofit.create(SettingsDatasource::class.java)
    }
}
