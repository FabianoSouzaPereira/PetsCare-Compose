package com.example.petscompose_class.data.models.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class RoomLogin(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "token") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
)