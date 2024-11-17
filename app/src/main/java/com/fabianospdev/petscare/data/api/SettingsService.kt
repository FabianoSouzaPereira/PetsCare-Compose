package com.fabianospdev.petscare.data.api

import com.fabianospdev.petscare.data.models.settings.local.RoomSettings
import retrofit2.Response
import retrofit2.http.GET

interface SettingsService {

    @GET("settings/{id}")
    suspend fun getCongig(): Response<RoomSettings>
}