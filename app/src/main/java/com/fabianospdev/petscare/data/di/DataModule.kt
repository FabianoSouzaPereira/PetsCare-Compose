package com.fabianospdev.petscare.data.di

import com.fabianospdev.petscare.data.repositories.UserRepositoryImpl
import com.fabianospdev.petscare.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    fun provideUserRepository(userApi: UserApi, userDao: UserDao): UserRepository {
        return UserRepositoryImpl(userApi, userDao)
    }
}
