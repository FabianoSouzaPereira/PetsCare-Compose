package com.fabianospdev.petscare.domain.repositories

import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel
import retrofit2.Response
import retrofit2.http.Path

interface UserRemoteRepository {
    suspend fun getAllUsers(): Result<Response<List<RemoteUserModel>>>
    suspend fun getUser(name: String, password: String): Result<Response<RemoteUserModel>>
    suspend fun getUserById(@Path("id") id: Int): Result<Response<RemoteUserModel>>
    suspend fun insertUser(user: RemoteUserModel): Result<Response<Void>>
    suspend fun updateUser(id: Int, user: RemoteUserModel): Result<Response<Void>>
    suspend fun deleteUser(id: Int): Result<Response<Void>>
    suspend fun getUserData(token: String): Result<Response<RemoteUserModel>>
}
