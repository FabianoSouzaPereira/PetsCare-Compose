package com.fabianospdev.petscare.presenter.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    var username by mutableStateOf(value = "email@gmail.com")
    var password by mutableStateOf(value = "123456")
    private  val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private var _count = 0
    val count: Int
        get() = _count
}