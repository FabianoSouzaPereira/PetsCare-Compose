package com.fabianospdev.petscare.data.di

import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.api.ProfileDatasource
import com.fabianospdev.petscare.data.api.SettingsDatasource
import com.fabianospdev.petscare.data.api.UserDatasource
import com.fabianospdev.petscare.data.dao.LoginDao
import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.data.repositories.LoginLocalRepositoryImpl
import com.fabianospdev.petscare.data.repositories.ProfileLocalRepositoryImpl
import com.fabianospdev.petscare.data.repositories.SettingsLocalRepositoryImpl
import com.fabianospdev.petscare.data.repositories.SettingsRepositoryImpl
import com.fabianospdev.petscare.data.repositories.UserLocalRepositoryImpl
import com.fabianospdev.petscare.domain.repositories.LoginLocalRepository
import com.fabianospdev.petscare.domain.repositories.ProfileLocalRepository
import com.fabianospdev.petscare.domain.repositories.SettingsLocalRepository
import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import com.fabianospdev.petscare.domain.repositories.UserLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    /**  DATASOURCES  **/

    @Provides
    fun provideLoginDatasource(retrofit: Retrofit): LoginDatasource {
        return retrofit.create(LoginDatasource::class.java)
    }
    @Provides
    fun provideUserDatasource(retrofit: Retrofit): UserDatasource {
        return retrofit.create(UserDatasource::class.java)
    }

    @Provides
    fun provideProfileDatasource(retrofit: Retrofit): ProfileDatasource {
        return retrofit.create(ProfileDatasource::class.java)
    }

    @Provides
    fun provideSettingsDatasource(retrofit: Retrofit): SettingsDatasource {
        return retrofit.create(SettingsDatasource::class.java)
    }

    @Provides
    fun provideLoginDao(retrofit: Retrofit): LoginDao {
        return retrofit.create(LoginDao::class.java)
    }
    @Provides
    fun provideUserDao(retrofit: Retrofit): UserDao {
        return retrofit.create(UserDao::class.java)
    }

    @Provides
    fun provideProfileDao(retrofit: Retrofit): ProfileDao {
        return retrofit.create(ProfileDao::class.java)
    }

    @Provides
    fun provideSettingsDao(retrofit: Retrofit): SettingsDao {
        return retrofit.create(SettingsDao::class.java)
    }

    /**  REPOSITORIES  **/

    @Provides
    fun provideSettingsRepository(settingsDao: SettingsDao): SettingsRepository {
        return SettingsRepositoryImpl(settingsDao)
    }

    @Provides
    fun provideUserLocalRepository(userDao: UserDao): UserLocalRepository {
        return UserLocalRepositoryImpl(userDao)
    }


    @Provides
    fun provideLoginLocalRepository(loginDao: LoginDao): LoginLocalRepository {
        return LoginLocalRepositoryImpl(loginDao)
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
