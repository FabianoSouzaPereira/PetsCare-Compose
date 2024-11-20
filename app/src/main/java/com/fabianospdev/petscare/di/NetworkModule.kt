package com.fabianospdev.petscare.di

/** NetworkModule is the same that Retrofit initializer */

import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.api.ProfileDatasource
import com.fabianospdev.petscare.data.api.SettingsDatasource
import com.fabianospdev.petscare.data.api.UserDatasource
import com.fabianospdev.petscare.domain.repositories.ProfileRemoteRepository
import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
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
            .baseUrl("https://api.petscare/")
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
    fun provideLoginDatasource(retrofit: Retrofit): LoginDatasource {
        return retrofit.create(LoginDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideUserDatasource(retrofit: Retrofit): UserDatasource {
        return retrofit.create(UserDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileDatasource(retrofit: Retrofit): ProfileDatasource {
        return retrofit.create(ProfileDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideSettingsDatasource(retrofit: Retrofit): SettingsDatasource {
        return retrofit.create(SettingsDatasource::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRemoteRepository(retrofit: Retrofit): UserRemoteRepository {
        return retrofit.create(UserRemoteRepository::class.java)
    }


    @Provides
    @Singleton
    fun provideSettingsRepository(retrofit: Retrofit): SettingsRepository {
        return retrofit.create(SettingsRepository::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(retrofit: Retrofit): ProfileRemoteRepository {
        return retrofit.create(ProfileRemoteRepository::class.java)
    }
}
