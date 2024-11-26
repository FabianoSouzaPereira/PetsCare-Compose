package com.example.petscompose_class.data.models.settings.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class RoomSettings (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "theme") val theme: String = "light",
    @ColumnInfo(name = "language") val language: String = "en",
    @ColumnInfo(name = "last_sync") val lastSync: String? = null,
    @ColumnInfo(name = "api_url") val apiUrl: String = "https://api.example.com",
    @ColumnInfo(name = "notifications_enabled") val notificationsEnabled: Boolean = true,
    @ColumnInfo(name = "app_version") val appVersion: String = "1.0.0",
    @ColumnInfo(name = "last_updated") val lastUpdated: Long = System.currentTimeMillis()
)
