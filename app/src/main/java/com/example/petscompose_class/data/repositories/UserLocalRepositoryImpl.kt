package com.example.petscompose_class.data.repositories

import com.example.petscompose_class.data.dao.UserDao
import com.example.petscompose_class.data.models.user.local.RoomUser
import com.example.petscompose_class.data.models.user.remote.RemoteUserModel
import com.example.petscompose_class.data.models.user.toRoomUser
import com.example.petscompose_class.domain.repositories.UserLocalRepository
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