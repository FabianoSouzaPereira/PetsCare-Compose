package com.fabianospdev.petscare.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fabianospdev.petscare.data.models.login.RoomLogin

@Dao
interface LoginDao {
    @Query(value = "SELECT * FROM login")
    suspend fun login(username: String, password: String): Result<RoomLogin>

    @Insert
    suspend fun insert(user: RoomLogin): Result<RoomLogin>

    @Update
    suspend fun update(user: RoomLogin): Result<RoomLogin>

    @Delete
    suspend fun delete(user: RoomLogin): Result<RoomLogin>
}