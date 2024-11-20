package com.fabianospdev.petscare.presenter.ui.login

import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel
import retrofit2.Response

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val user: Result<Response<RemoteUserModel>>) : LoginState()
    data class Error(val error: String) : LoginState()
}
