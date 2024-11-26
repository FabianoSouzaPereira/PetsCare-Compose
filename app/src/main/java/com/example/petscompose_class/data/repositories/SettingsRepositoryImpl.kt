package com.example.petscompose_class.data.repositories

import com.example.petscompose_class.data.dao.SettingsDao
import com.example.petscompose_class.data.models.settings.local.RoomSettings
import com.example.petscompose_class.domain.repositories.SettingsRepository
import javax.inject.Inject


class SettingsRepositoryImpl @Inject constructor(
    private val settingsDao: SettingsDao
): SettingsRepository {

    override suspend fun getConfig(): RoomSettings {
        return settingsDao.getSettings()
    }

    override suspend fun updateConfig(config: RoomSettings) {
        return settingsDao.updateSettings(config)
    }
}
