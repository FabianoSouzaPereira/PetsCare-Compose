package com.example.petscompose_class.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.petscompose_class.data.models.settings.local.RoomSettings

@Dao
interface SettingsDao {

    @Query(value = "SELECT * FROM settings")
    suspend fun getSettings(): RoomSettings

    @Insert
    suspend fun insertSettings(config: RoomSettings)

    @Update
    suspend fun updateSettings(config: RoomSettings)

    @Delete
    suspend fun deleteSettings(config: RoomSettings)
}