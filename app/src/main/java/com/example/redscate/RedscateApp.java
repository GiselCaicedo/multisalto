package com.example.redscate;

import android.app.Application;

public class RedscateApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ThemeManager.applySavedTheme(this);
    }
}
