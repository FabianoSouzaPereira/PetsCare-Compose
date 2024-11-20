package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.profile.RemoteProfile
import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel
import retrofit2.Response

interface ProfileRemoteRepository {
    suspend fun getProfile(profileId: Int): Response<RemoteProfile>
    suspend fun insertProfile(profile: RemoteProfile): Response<Void>
    suspend fun getUserDataProfile(token: String): Response<RemoteUserModel>
    suspend fun updateProfile(id: Int, profile: RemoteProfile): Response<Void>
    suspend fun deleteProfile(id: Int, profile: RemoteProfile): Response<Void>
}