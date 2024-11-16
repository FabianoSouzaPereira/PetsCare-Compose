package com.fabianospdev.petscare.presenter.ui.login

import com.fabianospdev.petscare.data.models.user.User

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val user: User) : LoginState()
    data class Error(val message: String) : LoginState()
}
