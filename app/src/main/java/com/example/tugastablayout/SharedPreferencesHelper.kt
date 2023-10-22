package com.example.tugastablayout

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context:Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


    fun saveCredentials(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("USERNAME", username)
        editor.putString("PASSWORD", password)
        editor.apply()
    }

    fun getUsername(): String? {
        return sharedPreferences.getString("USERNAME", null)
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("PASSWORD", null)
    }
}