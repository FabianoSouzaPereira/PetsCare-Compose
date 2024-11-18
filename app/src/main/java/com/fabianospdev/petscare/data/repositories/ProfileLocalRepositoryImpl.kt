package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.models.profile.RemoteProfile
import com.fabianospdev.petscare.domain.repositories.ProfileLocalRepository
import javax.inject.Inject

class ProfileLocalRepositoryImpl @Inject constructor(
    private val profileDao: ProfileDao
) : ProfileLocalRepository {

    override suspend fun getLocalProfile(profile: RemoteProfile) {
        return profileDao.getProfile(profile)
    }

    override suspend fun insertLocalProfile(profile: RemoteProfile) {
        return profileDao.insertProfile(profile)
    }

    override suspend fun updateLocalProfile(profile: RemoteProfile) {
        return profileDao.updateProfile(profile)
    }

    override suspend fun deleteLocalProfile(profile: RemoteProfile) {
        return profileDao.deleteProfile(profile)
    }

}