package com.fabianospdev.petscare.domain.usecases.user

import com.fabianospdev.petscare.data.models.user.local.RoomUser

interface UserLocalUsecase {
    suspend fun getUser(name: String, password: String): Result<RoomUser>
}