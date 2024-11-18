package com.fabianospdev.petscare.domain.usecases.login

import com.fabianospdev.petscare.data.models.login.LoginResponse
import com.fabianospdev.petscare.domain.repositories.LoginRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class LoginRemoteUsecase @Inject constructor(
    private val loginRemoteRepository: LoginRemoteRepository
) {
    suspend fun getUser(name: String, password: String): Result<Response<LoginResponse>> {
        return try {

            loginRemoteRepository.login(name, password)

        } catch (e: Exception) {
            Result.failure(Exception("Erro ao tentar fazer login: ${e.message}", e))
        }
    }
}
