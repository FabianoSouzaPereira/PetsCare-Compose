package com.fabianospdev.petscare.data.appdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fabianospdev.petscare.data.dao.LoginDao
import com.fabianospdev.petscare.data.dao.ProfileDao
import com.fabianospdev.petscare.data.dao.SettingsDao
import com.fabianospdev.petscare.data.dao.UserDao
import com.fabianospdev.petscare.data.models.login.RoomLogin
import com.fabianospdev.petscare.data.models.profile.RoomProfile
import com.fabianospdev.petscare.data.models.settings.local.RoomSettings
import com.fabianospdev.petscare.data.models.user.local.RoomUser

@Database(entities = [RoomUser::class, RoomLogin::class, RoomProfile::class, RoomSettings::class], version = 1,
exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun loginDao(): LoginDao
    abstract fun profileDao(): ProfileDao
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
