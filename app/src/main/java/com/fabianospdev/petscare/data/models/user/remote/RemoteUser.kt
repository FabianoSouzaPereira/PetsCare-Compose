package com.fabianospdev.petscare.data.models.user.remote

import com.google.gson.annotations.SerializedName

data class RemoteUser(
    val id: Int,
    val name: String,
    val email: String,
    @SerializedName("created_at") val createdAt: String
)