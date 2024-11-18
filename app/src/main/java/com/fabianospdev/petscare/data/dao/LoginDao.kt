package com.fabianospdev.petscare.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fabianospdev.petscare.data.models.login.RoomLogin

@Dao
interface LoginDao {
    @Query(value = "SELECT * FROM login")
    suspend fun login(username: String, password: String): Result<RoomLogin>

    @Insert
    suspend fun insert(user: RoomLogin): Result<RoomLogin>

    @Insert
    suspend fun update(user: RoomLogin): Result<RoomLogin>

    @Insert
    suspend fun delete(user: RoomLogin): Result<RoomLogin>
}