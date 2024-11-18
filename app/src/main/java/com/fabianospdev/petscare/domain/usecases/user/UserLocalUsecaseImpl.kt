package com.fabianospdev.petscare.domain.usecases.user

import com.fabianospdev.petscare.data.models.user.local.RoomUser
import com.fabianospdev.petscare.domain.repositories.UserLocalRepository
import javax.inject.Inject

class UserLocalUsecaseImpl @Inject constructor(private val userLocalRepository: UserLocalRepository) :
    UserLocalUsecase {
    override suspend fun getUser(name: String, password: String): Result<RoomUser> {
        return try {
            val response =  userLocalRepository.getLocalUser(name, password)

            if (response != null) {
                Result.success(response)
            } else {
                Result.failure(Exception("Usuário não encontrado"))
            }
        }catch (e: Exception) {
                Result.failure(e)
        }
    }
}