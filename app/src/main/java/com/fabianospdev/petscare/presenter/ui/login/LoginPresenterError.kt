package com.fabianospdev.petscare.presenter.ui.login

sealed class LoginPresenterError {
    object UserNotFound : LoginPresenterError()
    object LoginFailed : LoginPresenterError()
}
