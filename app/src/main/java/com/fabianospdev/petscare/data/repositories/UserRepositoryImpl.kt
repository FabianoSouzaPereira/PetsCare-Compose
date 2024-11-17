package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.api.UserService
import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.data.models.user.local.RoomUser
import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import com.fabianospdev.petscare.data.models.user.toRoomUser
import com.fabianospdev.petscare.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getUser(name: String, password: String): RemoteUser {
        val response = userService.getUser(name, password)

        if (response.isSuccessful) {
            return response.body()?.let { RemoteUser(it.id, it.name, it.email, it.createdAt) }
                ?: throw Exception("User not found")
        } else {
            throw Exception("Failed to fetch user")
        }
    }

    override suspend fun getLocalUser(id: Int): RoomUser {
        val response = userDao.getLocalUser(id)
        return response ?: throw Exception("User local not found")
    }

    override suspend fun insertUser(user: RoomUser){
       userDao.insertUser(user)
    }

    override suspend fun updateUser(user: RoomUser) {
        userDao.updateUser(user)
    }

    override suspend fun deleteUser(user: RoomUser) {
        userDao.deleteUser(user)
    }

    suspend fun saveUserToRoom(remoteUser: RemoteUser) {
        val roomUser = remoteUser.toRoomUser()
        userDao.insertUser(roomUser)
    }
}
