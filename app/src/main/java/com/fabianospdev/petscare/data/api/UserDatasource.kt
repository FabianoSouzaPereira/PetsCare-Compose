package com.fabianospdev.petscare.data.api

/* Retrofit will implements this Datasource */

import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

/** Datasource some times called Service **/
interface UserDatasource {

    @GET("user/{username}")
    suspend fun getUser(@Path("username") username: String, @Path("password") password: String): Response<RemoteUser>

    @GET("user/{id}")
    suspend fun getUserById(@Path("id") userId: Int): Response<RemoteUser>

    @GET("user/{user}")
    suspend fun insertUser(@Body user: RemoteUser): Response<Void>

    @PUT("user/{id}")
    suspend fun updateUser(@Path("id") userId: Int, @Body user: RemoteUser): Response<Void>

    @DELETE("user/{id}")
    suspend fun deleteUser(@Path("id") userId: Int): Response<Void>

    @GET("user/all")
    suspend fun getAllUsers(): Response<List<RemoteUser>>

    @GET("user/data")
    suspend fun userData(): Response<RemoteUser>
}

