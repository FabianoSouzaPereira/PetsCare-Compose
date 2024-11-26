package com.example.petscompose_class.domain.repositories

import com.example.petscompose_class.data.models.login.RoomLogin

interface LoginLocalRepository {
    suspend fun loginUser(username: String, password: String): RoomLogin?
    suspend fun insertUser(localLogin: RoomLogin) : Long
    suspend fun updateUser(localLogin: RoomLogin): Int
    suspend fun deleteUser(localLogin: RoomLogin): Int
}