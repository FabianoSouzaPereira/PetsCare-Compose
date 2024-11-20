package com.fabianospdev.petscare.data.models.user.remote

import com.fabianospdev.petscare.domain.entities.RemoteUserEntity
import com.google.gson.annotations.SerializedName

data class RemoteUserModel(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("email") override val email: String,
    @SerializedName("password") override val password: String,
    @SerializedName("created_at") override val createdAt: String
) : RemoteUserEntity