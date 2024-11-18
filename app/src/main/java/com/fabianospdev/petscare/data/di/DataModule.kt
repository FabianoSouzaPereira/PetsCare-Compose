package com.fabianospdev.petscare.data.di

import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.api.SettingsDatasource
import com.fabianospdev.petscare.data.api.UserDatasource
import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.data.repositories.LoginRepositoryImpl
import com.fabianospdev.petscare.data.repositories.SettingsRepositoryImpl
import com.fabianospdev.petscare.data.repositories.UserRemoteRepositoryImpl
import com.fabianospdev.petscare.domain.repositories.LoginRepository
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
    fun provideSettingsRepository(settingsService: SettingsDatasource, settingsDao: SettingsDao): SettingsRepository {
        return SettingsRepositoryImpl(settingsService,settingsDao)
    }

    @Provides
    fun provideUserService(retrofit: Retrofit): UserDatasource {
        return retrofit.create(UserDatasource::class.java)
    }

    @Provides
    fun provideUserRepository(userService: UserDatasource, userDao: UserDao): UserRemoteRepository {
        return UserRemoteRepositoryImpl(userService, userDao)
    }

    @Provides
    fun provideLoginService(retrofit: Retrofit): LoginDatasource {
        return retrofit.create(LoginDatasource::class.java)
    }

    @Provides
    fun provideLoginRepository(loginService: LoginDatasource): LoginRepository {
        return LoginRepositoryImpl(loginService)
    }
}
