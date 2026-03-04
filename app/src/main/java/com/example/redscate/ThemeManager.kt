package com.example.redscate

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {
    private const val PREFS_NAME = "redscate_prefs"
    private const val KEY_DARK_MODE = "dark_mode"
    private const val DEFAULT_DARK_MODE = true

    fun applySavedTheme(context: Context) {
        val isDark = isDarkMode(context)
        AppCompatDelegate.setDefaultNightMode(
            if (isDark) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
    }

    fun isDarkMode(context: Context): Boolean {
        return prefs(context).getBoolean(KEY_DARK_MODE, DEFAULT_DARK_MODE)
    }

    fun setDarkMode(context: Context, isDark: Boolean) {
        prefs(context).edit().putBoolean(KEY_DARK_MODE, isDark).apply()
        AppCompatDelegate.setDefaultNightMode(
            if (isDark) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
    }

    private fun prefs(context: Context): SharedPreferences {
        return context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}
