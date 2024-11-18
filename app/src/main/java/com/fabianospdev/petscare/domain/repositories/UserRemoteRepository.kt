package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import retrofit2.Response
import retrofit2.http.Path

interface UserRemoteRepository {
    suspend fun getAllUsers(): Result<Response<List<RemoteUser>>>
    suspend fun getUser(name: String): Result<Response<RemoteUser>>
    suspend fun getUserById(@Path("id") id: Int): Result<Response<RemoteUser>>
    suspend fun insertUser(user: RemoteUser): Result<Response<Void>>
    suspend fun updateUser(id: Int, user: RemoteUser): Result<Response<Void>>
    suspend fun deleteUser(id: Int): Result<Response<Void>>
}
