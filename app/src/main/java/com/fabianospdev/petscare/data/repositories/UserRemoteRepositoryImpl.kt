package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.api.UserDatasource
import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class UserRemoteRepositoryImpl @Inject constructor(
    private val datasource: UserDatasource
) : UserRemoteRepository {
    override suspend fun getAllUsers(): Result<Response<List<RemoteUser>>> {
        return try {
            val response = datasource.getAllUsers()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUser(name: String, password: String): Result<Response<RemoteUser>> {
        return try {
            val response = datasource.getUser(name, password)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUserById(id: Int): Result<Response<RemoteUser>> {
        return try {
            val response = datasource.getUserById(id)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun insertUser(user: RemoteUser): Result<Response<Void>> {
        return try {
            val response = datasource.insertUser(user)
            if (response.isSuccessful) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateUser(id: Int, user: RemoteUser): Result<Response<Void>> {
        return try {
            val response  = datasource.updateUser(user.id, user)
            if (response.isSuccessful) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteUser(id: Int): Result<Response<Void>> {
        return try {
            val response = datasource.deleteUser(id)
            if (response.isSuccessful) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUserData(token: String): Result<Response<RemoteUser>> {
        return try {
            val response = datasource.userData()
            if (response.isSuccessful){
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
