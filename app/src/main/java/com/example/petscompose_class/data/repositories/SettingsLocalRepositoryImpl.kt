package com.example.petscompose_class.data.repositories

import com.example.petscompose_class.data.dao.SettingsDao
import com.example.petscompose_class.data.models.settings.local.RoomSettings
import com.example.petscompose_class.domain.repositories.SettingsLocalRepository
import javax.inject.Inject

class SettingsLocalRepositoryImpl @Inject constructor(
    private val settingsDao: SettingsDao
) : SettingsLocalRepository {

    override suspend fun getLocalSettings(): RoomSettings {
        val response = settingsDao.getSettings()
        return response ?: throw Exception("User local not found")
    }

    override suspend fun insertLocalSettings(settings: RoomSettings) {
        settingsDao.insertSettings(settings)
    }

    override suspend fun updateLocalSettings(settings: RoomSettings) {
        settingsDao.updateSettings(settings)
    }

    override suspend fun deleteLocalSettings(settings: RoomSettings) {
        settingsDao.deleteSettings(settings)
    }
}