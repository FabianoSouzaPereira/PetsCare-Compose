package com.example.petscompose_class.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.petscompose_class.data.models.user.local.RoomUser

@Dao
interface UserDao {

    @Query(value = "SELECT * FROM user")
    suspend fun getAllUsers(): List<RoomUser>

    @Query(value = "SELECT * FROM user WHERE full_name = :name and password = :password Limit 1")
    suspend fun getLocalUser(name: String, password: String): RoomUser?

    @Insert
    suspend fun insertUser(user: RoomUser)

    @Update
    suspend fun updateUser(user: RoomUser)

    @Delete
    suspend fun deleteUser(user: RoomUser)
}