package com.fabianospdev.petscare.data.models.user.remote

import com.google.gson.annotations.SerializedName

data class RemoteUser(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("created_at") val createdAt: String
)