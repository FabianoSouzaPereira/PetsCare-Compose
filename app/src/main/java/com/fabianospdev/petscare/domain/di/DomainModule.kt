package com.fabianospdev.petscare.domain.di

import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
import com.fabianospdev.petscare.domain.usecases.UserRemoteUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRemoteRepository): UserRemoteUsecase {
        return UserRemoteUsecase(userRepository)
    }
}
