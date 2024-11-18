package com.fabianospdev.petscare.presenter.ui.login

import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import retrofit2.Response

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val user: Result<Response<RemoteUser>>) : LoginState()
    data class Error(val message: String) : LoginState()
}
