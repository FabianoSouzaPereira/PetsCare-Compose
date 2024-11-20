package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.api.ProfileDatasource
import com.fabianospdev.petscare.data.models.profile.RemoteProfile
import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel
import com.fabianospdev.petscare.domain.repositories.ProfileRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class ProfileRemoteRepositoryImpl @Inject constructor(
    private var profileDatasource: ProfileDatasource
): ProfileRemoteRepository {

    override suspend fun getProfile(profileId: Int): Response<RemoteProfile> {
        return profileDatasource.getProfile(profileId)
    }

    override suspend fun insertProfile(profile: RemoteProfile): Response<Void> {
        return profileDatasource.insertProfile(profile)
    }

    override suspend fun updateProfile(id: Int, profile: RemoteProfile): Response<Void> {
        return profileDatasource.updateProfile(id, profile)
    }

    override suspend fun deleteProfile(id: Int, profile: RemoteProfile): Response<Void> {
        return profileDatasource.deleteProfile(id)
    }

    override suspend fun getUserDataProfile(token: String): Response<RemoteUserModel> {
        return profileDatasource.getUserDataProfile(token)
    }
}