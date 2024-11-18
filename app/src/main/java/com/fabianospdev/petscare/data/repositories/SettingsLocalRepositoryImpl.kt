package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.models.settings.local.RoomSettings
import com.fabianospdev.petscare.domain.repositories.SettingsLocalRepository
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

//    suspend fun saveUserToRoomSettings(remoteSettings: RemoteSettings) {
//        val roomSettings  = remoteSettings.toRoomSettings()
//        settingsDao.insertSettings(roomSettings)
//    }
}