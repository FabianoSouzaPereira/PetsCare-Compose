package com.fabianospdev.petscare.data.models.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") val token: String
)