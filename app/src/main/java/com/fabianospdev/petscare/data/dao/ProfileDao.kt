package com.fabianospdev.petscare.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fabianospdev.petscare.data.models.profile.RemoteProfile

@Dao
interface ProfileDao {
    @Query(value = "SELECT * FROM profile")
    fun getProfile(profile: RemoteProfile)

    @Insert
    suspend fun insertProfile(profile: RemoteProfile)

    @Update
    suspend fun updateProfile(profile: RemoteProfile)

    @Delete
    suspend fun deleteProfile(profile: RemoteProfile)
}