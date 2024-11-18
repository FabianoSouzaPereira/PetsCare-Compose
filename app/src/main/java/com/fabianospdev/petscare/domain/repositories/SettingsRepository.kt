package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.settings.local.RoomSettings

interface SettingsRepository {
    suspend fun getConfig(): RoomSettings?
    suspend fun updateConfig(config: RoomSettings)
}
