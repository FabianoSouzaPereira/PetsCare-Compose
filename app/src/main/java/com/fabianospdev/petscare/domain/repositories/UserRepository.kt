package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.user.local.RoomUser
import com.fabianospdev.petscare.data.models.user.remote.RemoteUser

interface UserRepository {
    suspend fun getUser(name: String, password: String): RemoteUser
    suspend fun getLocalUser(id: Int): RoomUser?
    suspend fun insertUser(user: RoomUser)
    suspend fun updateUser(user: RoomUser)
    suspend fun deleteUser(user: RoomUser)
}
