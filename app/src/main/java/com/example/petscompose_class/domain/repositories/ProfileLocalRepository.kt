package com.example.petscompose_class.domain.repositories

import com.example.petscompose_class.data.models.profile.RoomProfile

interface ProfileLocalRepository {
    suspend fun getAllProfiles(): List<RoomProfile>?
    suspend fun getLocalProfile(id: Int) : RoomProfile?
    suspend fun insertLocalProfile(profile: RoomProfile)
    suspend fun updateLocalProfile(profile: RoomProfile)
    suspend fun deleteLocalProfile(profile: RoomProfile)
}