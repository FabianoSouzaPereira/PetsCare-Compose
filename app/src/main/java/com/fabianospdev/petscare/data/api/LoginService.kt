package com.fabianospdev.petscare.data.api

import com.fabianospdev.petscare.data.models.login.LoginRequest
import com.fabianospdev.petscare.data.models.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}
