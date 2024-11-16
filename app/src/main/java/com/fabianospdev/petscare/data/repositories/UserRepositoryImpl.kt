package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.models.user.User
import com.fabianospdev.petscare.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getUser(username: String, password: String): User {
        val response = userApi.getUser(username, password)

        if (response.isSuccessful) {
            return response.body()?.let { User(it.id, it.username, it.email) }
                ?: throw Exception("User not found")
        } else {
            throw Exception("Failed to fetch user")
        }
    }

    override suspend fun getLocalUser(username: String, password: String): User {
        val response = userDao.getLocalUser(username, password)
        if (response.isSuccessful) {
            return response.body()?.let { User(it.id, it.username, it.email) }
                ?: throw Exception("User local not found")
        } else {
            throw Exception("Failed to fetch local user")
        }
    }
}
