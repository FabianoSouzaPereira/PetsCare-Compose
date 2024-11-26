package com.example.petscompose_class.data.repositories

import com.example.petscompose_class.data.api.LoginDatasource
import com.example.petscompose_class.data.models.login.LoginRequestModel
import com.example.petscompose_class.data.models.login.LoginResponseModel
import com.example.petscompose_class.domain.repositories.LoginRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class LoginRemoteRepositoryImpl @Inject constructor(
    private val datasource: LoginDatasource
) : LoginRemoteRepository {

    override suspend fun login(username: String, password: String): Result<Response<LoginResponseModel>> {
        return try {
            val loginResponse = datasource.login(LoginRequestModel(username, password))

            if (loginResponse.isSuccessful && loginResponse.body() != null) {
                Result.success(loginResponse)
            } else {
                Result.failure(Throwable("Login failed: server response not valid"))
            }
        } catch (e: Exception) {
            Result.failure(Throwable("Authentication error: ${e.message}", e))
        }
    }

    override suspend fun logout() {
        try {
            datasource.logout()
        } catch (e: Exception) {
            throw Throwable("Error when logging out: ${e.message}", e)
        }
    }

    override suspend fun checkIfUserIsAuthenticated(): Boolean {
        return try {
            datasource.getAuthToken()
        } catch (e: Exception) {
            false
        }
    }
}
