package com.fabianospdev.petscare.presenter.ui.di

import com.fabianospdev.petscare.domain.usecases.login.LoginRemoteUsecase
import com.fabianospdev.petscare.presenter.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object PresentationModule {

    @Provides
    fun provideLoginViewModel(loginRemoteUsecase: LoginRemoteUsecase): LoginViewModel {
        return LoginViewModel(loginRemoteUsecase)
    }
}
