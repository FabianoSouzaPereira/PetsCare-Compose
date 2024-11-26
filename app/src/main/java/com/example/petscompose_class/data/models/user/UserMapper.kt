package com.example.petscompose_class.data.models.user

import com.example.petscompose_class.data.models.user.local.RoomUser
import com.example.petscompose_class.data.models.user.remote.RemoteUserModel

fun RemoteUserModel.toRoomUser(): RoomUser {
    return RoomUser(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password,
        createdAt = this.createdAt
    )
}
