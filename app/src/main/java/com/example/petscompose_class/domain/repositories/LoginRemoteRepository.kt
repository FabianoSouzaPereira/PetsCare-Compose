package com.example.petscompose_class.domain.repositories

import com.example.petscompose_class.data.models.login.LoginResponseModel
import retrofit2.Response

interface LoginRemoteRepository {
    suspend fun login(username: String, password: String): Result<Response<LoginResponseModel>>
    suspend fun logout()
    suspend fun checkIfUserIsAuthenticated(): Boolean
}