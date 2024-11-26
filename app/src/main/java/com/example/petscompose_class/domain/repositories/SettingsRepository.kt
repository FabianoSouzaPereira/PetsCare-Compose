package com.example.petscompose_class.domain.repositories

import com.example.petscompose_class.data.models.settings.local.RoomSettings

interface SettingsRepository {
    suspend fun getConfig(): RoomSettings?
    suspend fun updateConfig(config: RoomSettings)
}
