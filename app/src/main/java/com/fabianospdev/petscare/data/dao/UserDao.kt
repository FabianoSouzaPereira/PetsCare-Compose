package com.fabianospdev.petscare.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fabianospdev.petscare.data.models.user.local.RoomUser

@Dao
interface UserDao {

    @Query(value = "SELECT * FROM user")
    suspend fun getAllUsers(): List<RoomUser>

    @Query(value = "SELECT user FROM user WHERE id = :id Limit 1")
    suspend fun getLocalUser(id: Int): RoomUser?

    @Insert
    suspend fun insertUser(user: RoomUser)

    @Update
    suspend fun updateUser(user: RoomUser)

    @Delete
    suspend fun deleteUser(user: RoomUser)
}