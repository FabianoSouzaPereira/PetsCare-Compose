package com.example.petscompose_class.domain.usecases.user

import com.example.petscompose_class.data.models.user.remote.RemoteUserModel
import com.example.petscompose_class.domain.repositories.UserRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class UserRemoteUsecaseImpl @Inject constructor(
    private val userRemoteRepository: com.example.petscompose_class.domain.repositories.UserRemoteRepository
) : com.example.petscompose_class.domain.usecases.user.UserRemoteUsecase {

    override suspend fun getUser(name: String, password: String): Result<Response<RemoteUserModel>> {
        return userRemoteRepository.getUser(name, password)
    }
}
