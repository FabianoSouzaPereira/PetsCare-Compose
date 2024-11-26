package com.example.petscompose_class.data.manager

import android.content.Context

class TokenManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences.edit().putString("auth_token", token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("auth_token", null)
    }

    fun removeToken() {
        sharedPreferences.edit().remove("auth_token").apply()
    }
}
