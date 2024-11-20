package com.fabianospdev.petscare.data.models.login

import com.fabianospdev.petscare.domain.entities.RemoteLoginEntity
import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("token") override val token: String
) : RemoteLoginEntity