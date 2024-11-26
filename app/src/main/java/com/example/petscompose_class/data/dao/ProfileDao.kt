package com.example.petscompose_class.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.petscompose_class.data.models.profile.RoomProfile

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profile")
    suspend fun getAllProfiles(): List<RoomProfile>?

    @Query("SELECT * FROM profile WHERE id = :id LIMIT 1")
    suspend fun getProfile(id: Int) : RoomProfile?

    @Insert
    suspend fun insertProfile(profile: RoomProfile)

    @Update
    suspend fun updateProfile(profile: RoomProfile)

    @Delete
    suspend fun deleteProfile(profile: RoomProfile)
}