package com.fabianospdev.petscare.data.api

import com.fabianospdev.petscare.data.models.user.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("user/{id}")
    suspend fun getUser(@Path("username") username: String, @Path("password") password: String): Response<User>
}
