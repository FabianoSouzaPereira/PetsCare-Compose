package com.fabianospdev.petscare.data.repositories
import com.fabianospdev.petscare.data.api.LoginDatasource
import com.fabianospdev.petscare.data.models.login.LoginRequest
import com.fabianospdev.petscare.data.models.login.LoginResponse
import com.fabianospdev.petscare.domain.repositories.LoginRepository
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val datasource: LoginDatasource
) : LoginRepository {

    override suspend fun login(username: String, password: String): Result<Response<LoginResponse>> {
        return try {
            val loginResponse = datasource.login(LoginRequest(username, password))

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
