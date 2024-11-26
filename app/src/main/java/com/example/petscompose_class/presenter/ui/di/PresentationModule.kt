package com.example.petscompose_class.presenter.ui.di

import com.example.petscompose_class.core.helpers.RetryController
import com.example.petscompose_class.domain.usecases.login.LoginRemoteUsecase
import com.example.petscompose_class.presenter.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object PresentationModule {

    @Provides
    fun providerLoginViewModel(
        loginRemoteUsecase: LoginRemoteUsecase,
        retryController: RetryController
    ) : LoginViewModel {
        return LoginViewModel(usecase = loginRemoteUsecase, retryController = retryController)
    }
}
