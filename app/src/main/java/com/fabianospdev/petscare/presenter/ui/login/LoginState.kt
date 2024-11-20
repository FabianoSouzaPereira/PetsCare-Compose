package com.fabianospdev.petscare.presenter.ui.login

import com.fabianospdev.petscare.data.models.login.LoginResponseModel
import retrofit2.Response

sealed class LoginState {
    object Loading : LoginState()

    /**
     * Idle state: Represents when the login process hasn't started yet, and the system is waiting for user input.
     * It signifies that the system is idle, waiting for the user to initiate the login by filling in their credentials.
     */
    object Idle : LoginState()

    /**
     * Success state: Represents a successful login response. Contains the result of the login attempt, which includes
     * the response from the server (usually a success status and user data).
     */
    data class Success(val response: Result<Response<LoginResponseModel>>) : LoginState()

    /**
     * Error state: Represents a general error state that occurs if the login attempt fails. The error message can
     * be used to describe the nature of the failure (e.g., incorrect credentials).
     */
    data class Error(val error: String) : LoginState()

    /**
     * NoConnection state: Represents a failure caused by the absence of an internet connection. This state can be
     * used to notify the user that the app is unable to proceed due to network issues.
     */
    data class NoConnection(val errorMessage: String) : LoginState()

    /**
     * ValidationError state: Indicates a failure due to local validation issues, such as incorrect input format
     * (e.g., invalid email or password length) before attempting to contact the server.
     */
    data class ValidationError(val message: String) : LoginState()

    /**
     * TimeoutError state: Represents a timeout scenario where the server takes too long to respond to the login request,
     * signaling the need to retry or alert the user about the delay.
     */
    data class TimeoutError(val message: String) : LoginState()

    /**
     * Unauthorized state: Represents an authentication failure due to invalid credentials or lack of permission
     * (e.g., HTTP status 401). This state can be used to specifically handle unauthorized access errors.
     */
    data class Unauthorized(val message: String) : LoginState()
}

