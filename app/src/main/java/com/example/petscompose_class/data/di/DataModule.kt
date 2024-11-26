package com.example.petscompose_class.data.di

import com.example.petscompose_class.data.api.LoginDatasource
import com.example.petscompose_class.data.api.ProfileDatasource
import com.example.petscompose_class.data.api.SettingsDatasource
import com.example.petscompose_class.data.api.UserDatasource
import com.example.petscompose_class.data.dao.LoginDao
import com.example.petscompose_class.data.dao.SettingsDao
import com.example.petscompose_class.data.dao.UserDao
import com.example.petscompose_class.data.repositories.LoginLocalRepositoryImpl
import com.example.petscompose_class.data.repositories.ProfileLocalRepositoryImpl
import com.example.petscompose_class.data.repositories.SettingsLocalRepositoryImpl
import com.example.petscompose_class.data.repositories.UserLocalRepositoryImpl
import com.example.petscompose_class.domain.repositories.LoginLocalRepository
import com.example.petscompose_class.domain.repositories.ProfileLocalRepository
import com.example.petscompose_class.domain.repositories.SettingsLocalRepository
import com.example.petscompose_class.domain.repositories.UserLocalRepository
import com.example.petscompose_class.domain.repositories.UserRemoteRepository
import com.example.petscompose_class.domain.usecases.user.UserRemoteUsecase
import com.example.petscompose_class.domain.usecases.user.UserRemoteUsecaseImpl
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
    fun provideUserRemoteUseCase(userRemoteRepository: com.example.petscompose_class.domain.repositories.UserRemoteRepository): com.example.petscompose_class.domain.usecases.user.UserRemoteUsecase {
        return com.example.petscompose_class.domain.usecases.user.UserRemoteUsecaseImpl(userRemoteRepository)
    }

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
    fun provideProfileDao(retrofit: Retrofit): com.example.petscompose_class.data.dao.ProfileDao {
        return retrofit.create(com.example.petscompose_class.data.dao.ProfileDao::class.java)
    }

    @Provides
    fun provideSettingsDao(retrofit: Retrofit): SettingsDao {
        return retrofit.create(SettingsDao::class.java)
    }

    /**  REPOSITORIES  **/

    @Provides
    fun provideUserLocalRepository(userDao: UserDao): com.example.petscompose_class.domain.repositories.UserLocalRepository {
        return UserLocalRepositoryImpl(userDao)
    }

    @Provides
    fun provideLoginLocalRepository(loginDao: LoginDao): com.example.petscompose_class.domain.repositories.LoginLocalRepository {
        return LoginLocalRepositoryImpl(loginDao)
    }

    @Provides
    fun provideProfileLocalRepository(profileDao: com.example.petscompose_class.data.dao.ProfileDao): com.example.petscompose_class.domain.repositories.ProfileLocalRepository {
        return ProfileLocalRepositoryImpl(profileDao)
    }

    @Provides
    fun provideSettingsLocalRepository(settingsDao: SettingsDao): com.example.petscompose_class.domain.repositories.SettingsLocalRepository {
        return SettingsLocalRepositoryImpl(settingsDao)
    }

}
