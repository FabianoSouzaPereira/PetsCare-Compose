package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.User

interface UserRepository {
    suspend fun getUser(username: String, password: String): User
}
