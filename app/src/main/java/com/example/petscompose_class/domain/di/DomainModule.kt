package com.example.petscompose_class.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideUserRemoteUseCase(userRemoteRepository: com.example.petscompose_class.domain.repositories.UserRemoteRepository): com.example.petscompose_class.domain.usecases.user.UserRemoteUsecase {
        return com.example.petscompose_class.domain.usecases.user.UserRemoteUsecaseImpl(userRemoteRepository)
    }

    @Provides
    fun provideLoginRemoteUsecase(loginRemoteRepository: com.example.petscompose_class.domain.repositories.LoginRemoteRepository): com.example.petscompose_class.domain.usecases.login.LoginRemoteUsecase {
        return com.example.petscompose_class.domain.usecases.login.LoginRemoteUsecase(loginRemoteRepository)
    }

    @Provides
    fun provideProfileUsecase(profileRepository: com.example.petscompose_class.domain.repositories.ProfileRemoteRepository): com.example.petscompose_class.domain.usecases.ProfileUsecase {
        return com.example.petscompose_class.domain.usecases.ProfileUsecase(profileRepository)
    }

    @Provides
    fun provideSettingsUsecase(settingsRepository: com.example.petscompose_class.domain.repositories.SettingsRepository): com.example.petscompose_class.domain.usecases.SettingsUsecase {
        return com.example.petscompose_class.domain.usecases.SettingsUsecase(settingsRepository)
    }

    @Provides
    fun provideUserLocalUsecase(userLocalRepository: com.example.petscompose_class.domain.repositories.UserLocalRepository): com.example.petscompose_class.domain.usecases.user.UserLocalUsecase {
        return com.example.petscompose_class.domain.usecases.user.UserLocalUsecaseImpl(userLocalRepository)
    }

    @Provides
    fun provideUserRemoteUsecase(userRemoteRepository: com.example.petscompose_class.domain.repositories.UserRemoteRepository): com.example.petscompose_class.domain.usecases.user.UserRemoteUsecase {
        return com.example.petscompose_class.domain.usecases.user.UserRemoteUsecaseImpl(userRemoteRepository)
    }
}
