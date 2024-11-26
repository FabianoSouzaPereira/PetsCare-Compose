package com.example.petscompose_class.data.api

/* Retrofit will implements this Datasource */

import com.example.petscompose_class.data.models.login.LoginRequestModel
import com.example.petscompose_class.data.models.login.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/** Datasource some times called Service **/
interface LoginDatasource {

    @GET("login")
    suspend fun login(@Body loginRequest: LoginRequestModel): Response<LoginResponseModel>

    @POST("logout")
    suspend fun logout()

    @POST("checkAuthenticated")
    suspend fun getAuthToken() : Boolean
}
