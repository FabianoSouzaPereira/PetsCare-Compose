package com.example.petscompose_class.domain.usecases.user

import com.example.petscompose_class.data.models.user.local.RoomUser
import javax.inject.Inject

class UserLocalUsecaseImpl @Inject constructor(private val userLocalRepository: com.example.petscompose_class.domain.repositories.UserLocalRepository) :
    com.example.petscompose_class.domain.usecases.user.UserLocalUsecase {
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