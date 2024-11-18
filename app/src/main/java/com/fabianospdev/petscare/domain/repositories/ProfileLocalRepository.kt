package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.profile.RemoteProfile

interface ProfileLocalRepository {
    suspend fun getLocalProfile(profile: RemoteProfile)
    suspend fun insertLocalProfile(profile: RemoteProfile)
    suspend fun updateLocalProfile(profile: RemoteProfile)
    suspend fun deleteLocalProfile(profile: RemoteProfile)
}