package com.fabianospdev.petscare.data.models.user

import com.fabianospdev.petscare.data.models.user.local.RoomUser
import com.fabianospdev.petscare.data.models.user.remote.RemoteUserModel

fun RemoteUserModel.toRoomUser(): RoomUser {
    return RoomUser(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password,
        createdAt = this.createdAt
    )
}
