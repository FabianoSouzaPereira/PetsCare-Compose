package com.example.petscompose_class.data.api

/* Retrofit will implements this Datasource */

import com.example.petscompose_class.data.models.profile.RemoteProfile
import com.example.petscompose_class.data.models.user.remote.RemoteUserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/** Datasource some times called Service **/
interface ProfileDatasource {

    @GET("profile/{id}")
    suspend fun getProfile(@Path("id") profileId: Int): Response<RemoteProfile>

    @POST("profile/insert")
    suspend fun insertProfile(@Body profile: RemoteProfile): Response<Void>

    @PUT("profile/update/{id}")
    suspend fun updateProfile(@Path("id") id: Int, @Body profile: RemoteProfile): Response<Void>

    @DELETE("profile/{id}")
    suspend fun deleteProfile(@Path("id") id: Int): Response<Void>

    @GET("profile/user")
    suspend fun getUserDataProfile(@Header("token") token: String): Response<RemoteUserModel>
}

