package com.example.petscompose_class.data.appdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.petscompose_class.data.dao.LoginDao
import com.example.petscompose_class.data.dao.SettingsDao
import com.example.petscompose_class.data.dao.UserDao
import com.example.petscompose_class.data.models.login.RoomLogin
import com.example.petscompose_class.data.models.profile.RoomProfile
import com.example.petscompose_class.data.models.settings.local.RoomSettings
import com.example.petscompose_class.data.models.user.local.RoomUser


@Database(entities = [RoomUser::class, RoomLogin::class, RoomProfile::class, RoomSettings::class], version = 1,
exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun loginDao(): LoginDao
    abstract fun profileDao(): com.example.petscompose_class.data.dao.ProfileDao
    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
