package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.login.LoginResponseModel
import retrofit2.Response

interface LoginRemoteRepository {
    suspend fun login(username: String, password: String): Result<Response<LoginResponseModel>>
    suspend fun logout()
    suspend fun checkIfUserIsAuthenticated(): Boolean
}