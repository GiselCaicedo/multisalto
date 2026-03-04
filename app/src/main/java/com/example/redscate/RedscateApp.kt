package com.example.redscate

import android.app.Application

class RedscateApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ThemeManager.applySavedTheme(this)
    }
}
