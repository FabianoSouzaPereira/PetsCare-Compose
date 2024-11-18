package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.models.profile.RemoteProfile
import com.fabianospdev.petscare.domain.repositories.ProfileRemotoRepository
import javax.inject.Inject

class ProfileRemotoRepositoryImpl @Inject constructor(
    private var profileDao: ProfileDao
): ProfileRemotoRepository {

    override suspend fun getProfile(profile: RemoteProfile) {
        return profileDao.getProfile(profile)
    }

    override suspend fun insertProfile(profile: RemoteProfile) {
        return profileDao.insertProfile(profile)
    }

    override suspend fun updateProfile(profile: RemoteProfile) {
        return profileDao.updateProfile(profile)
    }

    override suspend fun deleteProfile(profile: RemoteProfile) {
        return profileDao.deleteProfile(profile)
    }
}