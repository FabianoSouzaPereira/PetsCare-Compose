package com.fabianospdev.petscare.domain.di

import com.fabianospdev.petscare.domain.repositories.LoginLocalRepository
import com.fabianospdev.petscare.domain.repositories.LoginRemoteRepository
import com.fabianospdev.petscare.domain.repositories.ProfileRemoteRepository
import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import com.fabianospdev.petscare.domain.repositories.UserLocalRepository
import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
import com.fabianospdev.petscare.domain.usecases.ProfileUsecase
import com.fabianospdev.petscare.domain.usecases.SettingsUsecase
import com.fabianospdev.petscare.domain.usecases.login.LoginLocalUsecase
import com.fabianospdev.petscare.domain.usecases.login.LoginRemoteUsecase
import com.fabianospdev.petscare.domain.usecases.user.UserLocalUsecase
import com.fabianospdev.petscare.domain.usecases.user.UserLocalUsecaseImpl
import com.fabianospdev.petscare.domain.usecases.user.UserRemoteUsecase
import com.fabianospdev.petscare.domain.usecases.user.UserRemoteUsecaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideUserRemoteUseCase(userRemoteRepository: UserRemoteRepository): UserRemoteUsecase {
        return UserRemoteUsecaseImpl(userRemoteRepository)
    }

    @Provides
    fun provideLoginRemoteUsecase(loginRemoteRepository: LoginRemoteRepository): LoginRemoteUsecase {
        return LoginRemoteUsecase(loginRemoteRepository)
    }

    @Provides
    fun provideLoginLocalUsecase(loginLocalRepository: LoginLocalRepository): LoginLocalUsecase {
        return LoginLocalUsecase(loginLocalRepository)
    }

    @Provides
    fun provideProfileUsecase(profileRepository: ProfileRemoteRepository): ProfileUsecase {
        return ProfileUsecase(profileRepository)
    }

    @Provides
    fun provideSettingsUsecase(settingsRepository: SettingsRepository): SettingsUsecase {
        return SettingsUsecase(settingsRepository)
    }

    @Provides
    fun provideUserLocalUsecase(userLocalRepository: UserLocalRepository): UserLocalUsecase {
        return UserLocalUsecaseImpl(userLocalRepository)
    }

    @Provides
    fun provideUserRemoteUsecase(loginRemoteRepository: LoginRemoteRepository): LoginRemoteUsecase {
        return LoginRemoteUsecase(loginRemoteRepository)
    }
}
