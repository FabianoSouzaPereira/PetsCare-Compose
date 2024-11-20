package com.fabianospdev.petscare.domain.usecases.login

import com.fabianospdev.petscare.data.models.login.LoginResponseModel
import com.fabianospdev.petscare.domain.repositories.LoginRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class LoginRemoteUsecase @Inject constructor(
    private val repository: LoginRemoteRepository
) {
    suspend fun login(name: String, password: String): Result<Response<LoginResponseModel>> {
        return try {
            repository.login(name, password)
        } catch (e: Exception) {
            Result.failure(Exception("Erro ao tentar fazer login: ${e.message}", e))
        }
    }
}