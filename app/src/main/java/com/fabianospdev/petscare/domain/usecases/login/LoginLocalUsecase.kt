package com.fabianospdev.petscare.domain.usecases.login

import com.fabianospdev.petscare.data.models.login.RoomLogin
import com.fabianospdev.petscare.domain.repositories.LoginLocalRepository
import javax.inject.Inject

class LoginLocalUsecase @Inject constructor(
    private val loginLocalRepository: LoginLocalRepository
): LoginLocalRepository {

    override suspend fun loginUser(username: String, password: String): Result<RoomLogin?> {
        return try {
            val User = loginLocalRepository.loginUser(username,password)

            if (User.isSuccess) {
                User
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            return Result.failure(Exception("Falha ao salvar usuário localmente: ${e.message}", e))
        }
    }

    override suspend fun insertUser(localLogin: RoomLogin): Result<RoomLogin> {
        return loginLocalRepository.insertUser(localLogin)
    }

    override suspend fun updateUser(localLogin: RoomLogin): Result<RoomLogin> {
        return loginLocalRepository.updateUser(localLogin)
    }

    override suspend fun deleteUser(localLogin: RoomLogin): Result<RoomLogin> {
        return loginLocalRepository.deleteUser(localLogin)
    }
}