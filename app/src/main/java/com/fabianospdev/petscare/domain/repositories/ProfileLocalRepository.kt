package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.profile.RoomProfile

interface ProfileLocalRepository {
    suspend fun getAllProfiles(): List<RoomProfile>?
    suspend fun getLocalProfile(id: Int) : RoomProfile?
    suspend fun insertLocalProfile(profile: RoomProfile)
    suspend fun updateLocalProfile(profile: RoomProfile)
    suspend fun deleteLocalProfile(profile: RoomProfile)
}