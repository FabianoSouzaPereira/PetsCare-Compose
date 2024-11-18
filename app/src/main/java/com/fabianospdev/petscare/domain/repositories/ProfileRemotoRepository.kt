package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.profile.RemoteProfile

interface ProfileRemotoRepository {
    suspend fun getProfile(profile: RemoteProfile)
    suspend fun insertProfile(profile: RemoteProfile)
    suspend fun updateProfile(profile: RemoteProfile)
    suspend fun deleteProfile(profile: RemoteProfile)
}