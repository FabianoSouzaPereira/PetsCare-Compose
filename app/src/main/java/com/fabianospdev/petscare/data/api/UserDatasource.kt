package com.fabianospdev.petscare.data.api

/* Retrofit will implements this Datasource */

import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

/** Datasource some times called Service **/
interface UserDatasource {

    @GET("user/{username}")
    suspend fun getUser(@Path("username") username: String, @Path("password") password: String): Response<RemoteUserModel>

    @GET("user/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<RemoteUserModel>

    @GET("user/{user}")
    suspend fun insertUser(@Body user: RemoteUserModel): Response<Void>

    @PUT("user/{id}")
    suspend fun updateUser(@Path("id") userId: Int, @Body user: RemoteUserModel): Response<Void>

    @DELETE("user/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): Response<Void>

    @GET("user/all")
    suspend fun getAllUsers(): Response<List<RemoteUserModel>>

    @GET("user/data")
    suspend fun userData(): Response<RemoteUserModel>
}

