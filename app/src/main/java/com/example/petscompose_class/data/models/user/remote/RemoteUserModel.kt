package com.example.petscompose_class.data.models.user.remote

import com.example.petscompose_class.domain.entities.RemoteUserEntity
import com.google.gson.annotations.SerializedName

data class RemoteUserModel(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("email") override val email: String,
    @SerializedName("password") override val password: String,
    @SerializedName("created_at") override val createdAt: String
) : RemoteUserEntity