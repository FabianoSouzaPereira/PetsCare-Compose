package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.login.LoginResponse
import retrofit2.Response

interface LoginRepository {
    suspend fun login(username: String, password: String): Result<Response<LoginResponse>>
    suspend fun logout()
    suspend fun checkIfUserIsAuthenticated(): Boolean
}