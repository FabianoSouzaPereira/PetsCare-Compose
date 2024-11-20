package com.fabianospdev.petscare.domain.usecases.login

import com.fabianospdev.petscare.data.models.login.LoginError
import com.fabianospdev.petscare.data.models.login.RoomLogin
import com.fabianospdev.petscare.domain.repositories.LoginLocalRepository
import javax.inject.Inject

class LoginLocalUsecase @Inject constructor(
    private val loginLocalRepository: LoginLocalRepository
): LoginLocalRepository {
    
    override suspend fun loginUser(username: String, password: String): RoomLogin? {
        return try {

            loginLocalRepository.loginUser(username, password) ?: throw Exception(LoginError.USER_NOT_FOUND.name)
        } catch (e: Exception) {
            throw Exception(LoginError.LOGIN_FAILED.name, e)
        }
    }

    override suspend fun insertUser(localLogin: RoomLogin): Long {
        return loginLocalRepository.insertUser(localLogin)
    }

    override suspend fun updateUser(localLogin: RoomLogin): Int {
        return loginLocalRepository.updateUser(localLogin)
    }

    override suspend fun deleteUser(localLogin: RoomLogin): Int {
        return loginLocalRepository.deleteUser(localLogin)
    }
}