package com.fabianospdev.petscare.data.di

import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.api.UserDatasource
import com.fabianospdev.petscare.data.dao.LoginDao
import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.data.repositories.LoginLocalRepositoryImpl
import com.fabianospdev.petscare.data.repositories.LoginRemoteRepositoryImpl
import com.fabianospdev.petscare.data.repositories.ProfileLocalRepositoryImpl
import com.fabianospdev.petscare.data.repositories.ProfileRemotoRepositoryImpl
import com.fabianospdev.petscare.data.repositories.SettingsLocalRepositoryImpl
import com.fabianospdev.petscare.data.repositories.SettingsRepositoryImpl
import com.fabianospdev.petscare.data.repositories.UserRemoteRepositoryImpl
import com.fabianospdev.petscare.domain.repositories.LoginLocalRepository
import com.fabianospdev.petscare.domain.repositories.LoginRemoteRepository
import com.fabianospdev.petscare.domain.repositories.ProfileLocalRepository
import com.fabianospdev.petscare.domain.repositories.ProfileRemotoRepository
import com.fabianospdev.petscare.domain.repositories.SettingsLocalRepository
import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideSettingsRepository(
        settingsDao: SettingsDao
    ): SettingsRepository {
        return SettingsRepositoryImpl(settingsDao)
    }

    @Provides
    fun provideUserDatasource(retrofit: Retrofit): UserDatasource {
        return retrofit.create(UserDatasource::class.java)
    }

    @Provides
    fun provideUserRepository(userDatasource: UserDatasource, userDao: UserDao): UserRemoteRepository {
        return UserRemoteRepositoryImpl(userDatasource)
    }

    @Provides
    fun provideLoginService(retrofit: Retrofit): LoginDatasource {
        return retrofit.create(LoginDatasource::class.java)
    }

    @Provides
    fun provideLoginRemotoRepository(loginDatasource: LoginDatasource): LoginRemoteRepository {
        return LoginRemoteRepositoryImpl(loginDatasource)
    }

    @Provides
    fun provideLoginLocalRepository(loginDao: LoginDao): LoginLocalRepository {
        return LoginLocalRepositoryImpl(loginDao)
    }

    @Provides
    fun provideProfileRemotoRepository(profileDao: ProfileDao): ProfileRemotoRepository {
        return ProfileRemotoRepositoryImpl(profileDao)
    }

    @Provides
    fun provideProfileLocalRepository(profileDao: ProfileDao): ProfileLocalRepository {
        return ProfileLocalRepositoryImpl(profileDao)
    }

    @Provides
    fun provideSettingsLocalRepository(settingsDao: SettingsDao): SettingsLocalRepository {
        return SettingsLocalRepositoryImpl(settingsDao)
    }

}
