package com.example.petscompose_class.data.api

/* Retrofit will implements this Datasource */

import com.example.petscompose_class.data.models.settings.local.RoomSettings
import retrofit2.Response
import retrofit2.http.GET

/** Datasource some times called Service **/
interface SettingsDatasource {

    @GET("settings/{id}")
    suspend fun getCongig(): Response<RoomSettings>
}