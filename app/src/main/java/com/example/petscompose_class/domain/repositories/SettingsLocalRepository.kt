package com.example.petscompose_class.domain.repositories

import com.example.petscompose_class.data.models.settings.local.RoomSettings

interface SettingsLocalRepository {
    suspend fun getLocalSettings(): RoomSettings?
    suspend fun insertLocalSettings(settings: RoomSettings)
    suspend fun updateLocalSettings(settings: RoomSettings)
    suspend fun deleteLocalSettings(settings: RoomSettings)
}