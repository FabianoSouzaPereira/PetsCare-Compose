package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.login.RoomLogin

interface LoginLocalRepository {
    suspend fun loginUser(username: String, password: String): RoomLogin?
    suspend fun insertUser(localLogin: RoomLogin) : Long
    suspend fun updateUser(localLogin: RoomLogin): Int
    suspend fun deleteUser(localLogin: RoomLogin): Int
}