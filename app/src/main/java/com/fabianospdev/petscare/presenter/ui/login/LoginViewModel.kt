package com.fabianospdev.petscare.presenter.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabianospdev.petscare.domain.usecases.UserRemoteUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserUseCase: UserRemoteUsecase
) : ViewModel() {

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> get() = _state

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val user = getUserUseCase.getUser(username, password)
                _state.value = LoginState.Success(user)
            } catch (e: Exception) {
                _state.value = LoginState.Error("Login failed")
            }
        }
    }
}
