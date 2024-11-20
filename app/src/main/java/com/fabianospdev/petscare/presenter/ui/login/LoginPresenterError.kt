package com.fabianospdev.petscare.presenter.ui.login

sealed class LoginPresenterError(val message: String) {
    object UserNotFound : LoginPresenterError("User not found.")
    object LoginFailed : LoginPresenterError("Login failed. Please try again.")
    object TimeoutError : LoginPresenterError("Request timed out. Please check your internet connection.")
    object Unauthorized : LoginPresenterError("Unauthorized access. Please check your credentials.")
    object ValidationError : LoginPresenterError("Validation failed. Please check the entered data.")
    object UnknownError : LoginPresenterError("Unknown error.")
}
