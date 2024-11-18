package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.login.RoomLogin

interface LoginLocalRepository {
    suspend fun loginUser(username: String, password: String): Result<RoomLogin?>
    suspend fun insertUser(localLogin: RoomLogin) : Result<RoomLogin>
    suspend fun updateUser(localLogin: RoomLogin): Result<RoomLogin>
    suspend fun deleteUser(localLogin: RoomLogin): Result<RoomLogin>
}