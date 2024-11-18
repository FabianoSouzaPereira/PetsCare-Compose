package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.settings.local.RoomSettings

interface SettingsLocalRepository {
    suspend fun getLocalSettings(): RoomSettings?
    suspend fun insertLocalSettings(settings: RoomSettings)
    suspend fun updateLocalSettings(settings: RoomSettings)
    suspend fun deleteLocalSettings(settings: RoomSettings)
}