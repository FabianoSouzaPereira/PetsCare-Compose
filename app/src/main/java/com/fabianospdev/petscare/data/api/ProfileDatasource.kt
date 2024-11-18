package com.fabianospdev.petscare.data.api

/* Retrofit will implements this Datasource */

import com.fabianospdev.petscare.data.models.profile.Profile
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/** Datasource some times called Service **/
interface ProfileDatasource {

    @GET("profile/{id}")
    suspend fun getProfile(@Path("id") userId: Int): Response<Profile>
}
