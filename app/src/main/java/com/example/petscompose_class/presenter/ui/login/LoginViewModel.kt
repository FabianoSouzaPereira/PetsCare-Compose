package com.example.petscompose_class.presenter.ui.login

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petscompose_class.core.helpers.RetryController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val usecase: com.example.petscompose_class.domain.usecases.login.LoginRemoteUsecase,
    private val retryController: RetryController
) : ViewModel() {

    /** Input fields status **/
    var username = mutableStateOf("")
    var password = mutableStateOf("")

    /** Field validation (calculated in a derived way) **/
    var isUserNameEmpty = derivedStateOf { username.value.isEmpty() }
    var isPasswordEmpty = derivedStateOf { password.value.isEmpty() }
    var isFormValid = derivedStateOf { username.value.isNotEmpty() && password.value.isNotEmpty() }

    private val _showRetryLimitReached = MutableStateFlow(false)
    val showRetryLimitReached: StateFlow<Boolean> get() = _showRetryLimitReached

    private val _state = MutableLiveData<LoginState>(LoginState.Idle)
    val state: LiveData<LoginState> get() = _state

    fun login(username: String, password: String){
        if (!retryController.isRetryEnabled.value) {
            _showRetryLimitReached.value = true
            return
        }
        _state.value = LoginState.Loading

        viewModelScope.launch {
            try {
                delay(2000) //todo remove it

                val result = usecase.login(username, password)
                if (result.isSuccess) {
                    _state.value = LoginState.Success(result)
                    retryController.resetRetryCount()
                } else {
                    retryController.incrementRetryCount()
                    _state.value = LoginState.Error(LoginPresenterError.LoginFailed.message)
                }

            } catch (e: Exception){
                retryController.incrementRetryCount()
                _state.value = when (e){
                    is com.example.petscompose_class.domain.exceptions.UserNotFoundException -> LoginState.Error(
                        LoginPresenterError.UserNotFound.message
                    )
                    is com.example.petscompose_class.domain.exceptions.TimeoutException -> LoginState.TimeoutError(
                        LoginPresenterError.TimeoutError.message
                    )
                    is com.example.petscompose_class.domain.exceptions.UnauthorizedException -> LoginState.Unauthorized(
                        LoginPresenterError.Unauthorized.message
                    )
                    is com.example.petscompose_class.domain.exceptions.ValidationException -> LoginState.ValidationError(
                        LoginPresenterError.ValidationError.message
                    )
                    else -> LoginState.Error(LoginPresenterError.LoginFailed.message)
                }
            }
        }
    }

    fun resetRetryLimitNotification() {
        _showRetryLimitReached.value = false
        retryController.resetRetryCount()
    }

    fun resetState() {
        _state.value = LoginState.Idle
    }

    fun clearInputFields() {
        username.value = ""
        password.value = ""
    }
}