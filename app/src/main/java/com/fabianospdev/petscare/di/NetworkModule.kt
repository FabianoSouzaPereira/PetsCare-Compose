package com.fabianospdev.petscare.di

import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.api.ProfileDatasource
import com.fabianospdev.petscare.data.api.SettingsDatasource
import com.fabianospdev.petscare.data.api.UserDatasource
import com.fabianospdev.petscare.data.dao.LoginDao
import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.domain.repositories.ProfileRemotoRepository
import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import com.fabianospdev.petscare.domain.repositories.UserLocalRepository
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
    fun provideLoginDao(retrofit: Retrofit): LoginDao {
        return retrofit.create(LoginDao::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileDao(retrofit: Retrofit): ProfileDao {
        return retrofit.create(ProfileDao::class.java)
    }

    @Provides
    @Singleton
    fun provideSettingsDao(retrofit: Retrofit): SettingsDao {
        return retrofit.create(SettingsDao::class.java)
    }

    @Provides
    @Singleton
    fun provideUserDao(retrofit: Retrofit): UserDao {
        return retrofit.create(UserDao::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRemoteRepository(retrofit: Retrofit): UserRemoteRepository {
        return retrofit.create(UserRemoteRepository::class.java)
    }

    @Provides
    @Singleton
    fun provideUserLocalRepository(retrofit: Retrofit): UserLocalRepository {
        return retrofit.create(UserLocalRepository::class.java)
    }

    @Provides
    @Singleton
    fun provideSettingsRepository(retrofit: Retrofit): SettingsRepository {
        return retrofit.create(SettingsRepository::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(retrofit: Retrofit): ProfileRemotoRepository {
        return retrofit.create(ProfileRemotoRepository::class.java)
    }
}
