package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.models.settings.local.RoomSettings
import com.fabianospdev.petscare.domain.repositories.SettingsRepository
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
