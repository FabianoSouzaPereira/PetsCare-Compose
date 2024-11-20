package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.data.models.user.local.RoomUser
import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel
import com.fabianospdev.petscare.data.models.user.toRoomUser
import com.fabianospdev.petscare.domain.repositories.UserLocalRepository
import javax.inject.Inject

class UserLocalRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): UserLocalRepository {

    override suspend fun getLocalUser(name: String, password: String): RoomUser {
        val response = userDao.getLocalUser(name, password)
        return response ?: throw Exception("User local not found")
    }

    override suspend fun insertLocalUser(user: RoomUser) {
        userDao.insertUser(user = user)
    }

    override suspend fun updateLocalUser(user: RoomUser) {
        userDao.updateUser(user = user)
    }

    override suspend fun deleteLocalUser(user: RoomUser) {
        userDao.deleteUser(user = user)
    }

    suspend fun saveUserToRoom(remoteUser: RemoteUserModel) {
        val roomUser = remoteUser.toRoomUser()
        userDao.insertUser(roomUser)
    }
}