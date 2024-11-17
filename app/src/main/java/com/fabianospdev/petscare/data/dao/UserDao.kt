package com.fabianospdev.petscare.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fabianospdev.petscare.data.models.user.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query(value = "SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Delete
    suspend fun deleteUser(user: User)
}