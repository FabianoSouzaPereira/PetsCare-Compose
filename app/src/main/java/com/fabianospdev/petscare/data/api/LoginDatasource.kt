package com.fabianospdev.petscare.data.api

/* Retrofit will implements this Datasource */

import com.fabianospdev.petscare.data.models.login.LoginRequest
import com.fabianospdev.petscare.data.models.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/** Datasource some times called Service **/
interface LoginDatasource {

    @GET("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("logout")
    suspend fun logout()

    @POST("checkAuthenticated")
    suspend fun getAuthToken() : Boolean
}
