package com.fabianospdev.petscare.presenter.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabianospdev.petscare.domain.exceptions.TimeoutException
import com.fabianospdev.petscare.domain.exceptions.UnauthorizedException
import com.fabianospdev.petscare.domain.exceptions.UserNotFoundException
import com.fabianospdev.petscare.domain.exceptions.ValidationException
import com.fabianospdev.petscare.domain.usecases.login.LoginRemoteUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val usecase: LoginRemoteUsecase
) : ViewModel() {

    private val _state = MutableLiveData<LoginState>(LoginState.Idle)
    val state: LiveData<LoginState> get() = _state

    fun login(username: String, password: String) {
        _state.value = LoginState.Loading

        viewModelScope.launch {
            try {
                val result = usecase.login(username, password)
                if (result.isSuccess) {
                    _state.value = LoginState.Success(result)
                } else {
                    _state.value = LoginState.Error(LoginPresenterError.LoginFailed.message)
                }
            } catch (e: Exception) {
                _state.value = when (e) {
                    is UserNotFoundException -> LoginState.Error(LoginPresenterError.UserNotFound.message)
                    is TimeoutException -> LoginState.TimeoutError(LoginPresenterError.TimeoutError.message)
                    is UnauthorizedException -> LoginState.Unauthorized(LoginPresenterError.Unauthorized.message)
                    is ValidationException -> LoginState.ValidationError(LoginPresenterError.ValidationError.message)
                    else -> LoginState.Error(LoginPresenterError.LoginFailed.message)
                }
            }
        }
    }

    fun resetState() {
        _state.value = LoginState.Idle
    }
}
