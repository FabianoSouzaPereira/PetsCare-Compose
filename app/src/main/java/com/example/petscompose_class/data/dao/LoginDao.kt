package com.example.petscompose_class.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.petscompose_class.data.models.login.RoomLogin

@Dao
interface LoginDao {

    @Query(value = "SELECT * FROM login WHERE email = :username and password = :password LIMIT 1")
    suspend fun login(username: String, password: String): RoomLogin?

    @Insert
    suspend fun insert(user: RoomLogin): Long

    @Update
    suspend fun update(user: RoomLogin): Int

    @Delete
    suspend fun delete(user: RoomLogin): Int
}