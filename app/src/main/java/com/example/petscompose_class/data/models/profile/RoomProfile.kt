package com.example.petscompose_class.data.models.profile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
data class RoomProfile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "token") val token: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int
)
