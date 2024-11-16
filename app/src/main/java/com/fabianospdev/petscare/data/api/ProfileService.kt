package com.fabianospdev.petscare.data.api

import com.fabianospdev.petscare.data.models.profile.Profile
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {

    @GET("profile/{id}")
    suspend fun getProfile(@Path("id") userId: Int): Response<Profile>
}
