package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.user.User

interface UserRepository {
    suspend fun getUser(username: String, password: String): User
    suspend fun getLocalUser(username: String, password: String): User
}
