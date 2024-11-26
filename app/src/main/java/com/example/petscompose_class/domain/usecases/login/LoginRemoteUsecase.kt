package com.example.petscompose_class.domain.usecases.login

import com.example.petscompose_class.data.models.login.LoginResponseModel
import com.example.petscompose_class.domain.repositories.LoginRemoteRepository
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