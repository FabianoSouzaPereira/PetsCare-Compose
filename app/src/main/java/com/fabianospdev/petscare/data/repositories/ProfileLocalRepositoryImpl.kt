package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.models.profile.RoomProfile
import com.fabianospdev.petscare.domain.repositories.ProfileLocalRepository
import javax.inject.Inject

class ProfileLocalRepositoryImpl @Inject constructor(
    private val profileDao: ProfileDao
) : ProfileLocalRepository {

    override suspend fun getAllProfiles(): List<RoomProfile>? {
        return profileDao.getAllProfiles()
    }

    override suspend fun getLocalProfile(id: Int) : RoomProfile? {
        return profileDao.getProfile(id)
    }

    override suspend fun insertLocalProfile(profile: RoomProfile) {
        return profileDao.insertProfile(profile)
    }

    override suspend fun updateLocalProfile(profile: RoomProfile) {
        return profileDao.updateProfile(profile)
    }

    override suspend fun deleteLocalProfile(profile: RoomProfile) {
        return profileDao.deleteProfile(profile)
    }

}