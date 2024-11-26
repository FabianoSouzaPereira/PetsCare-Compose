package com.example.petscompose_class.data.models.login

import com.example.petscompose_class.domain.entities.RemoteLoginEntity
import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("token") override val token: String
) : RemoteLoginEntity