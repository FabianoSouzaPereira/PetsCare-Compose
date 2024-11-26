package com.example.petscompose_class.domain.usecases.user

import com.example.petscompose_class.data.models.user.remote.RemoteUserModel
import retrofit2.Response

interface UserRemoteUsecase  {

    suspend fun getUser(name: String, password: String): Result<Response<RemoteUserModel>>
}
