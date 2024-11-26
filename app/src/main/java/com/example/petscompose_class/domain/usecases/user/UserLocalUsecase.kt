package com.example.petscompose_class.domain.usecases.user

import com.example.petscompose_class.data.models.user.local.RoomUser

interface UserLocalUsecase {
    suspend fun getUser(name: String, password: String): Result<RoomUser>
}