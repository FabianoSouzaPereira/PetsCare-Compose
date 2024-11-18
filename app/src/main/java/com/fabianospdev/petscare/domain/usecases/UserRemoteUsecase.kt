package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.data.models.user.remote.RemoteUser
import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
import javax.inject.Inject

class UserRemoteUsecase @Inject constructor(
    private val userRepository: UserRemoteRepository
) {

    suspend fun getUser(name: String, password: String): Result<RemoteUser> {
        return try {
            val user = userRepository.getUser(name, password)
            if (user != null) {
                Result.success(user)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
