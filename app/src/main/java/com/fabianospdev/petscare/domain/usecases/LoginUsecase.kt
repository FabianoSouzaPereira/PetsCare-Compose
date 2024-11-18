package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import com.fabianospdev.petscare.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginUsecase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend fun getUser(name: String, password: String): RemoteUser {
        return try {
            val user = repository.getLogin(name, password)
                return user

        } catch (e: Exception) {
            return e.message
        }
    }
}