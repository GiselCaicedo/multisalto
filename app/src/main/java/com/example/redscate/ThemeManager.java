package com.example.redscate;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public final class ThemeManager {
    private static final String PREFS_NAME = "redscate_prefs";
    private static final String KEY_DARK_MODE = "dark_mode";
    private static final boolean DEFAULT_DARK_MODE = true;

    private ThemeManager() {
    }

    public static void applySavedTheme(Context context) {
        boolean isDark = isDarkMode(context);
        AppCompatDelegate.setDefaultNightMode(
                isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );
    }

    public static boolean isDarkMode(Context context) {
        return prefs(context).getBoolean(KEY_DARK_MODE, DEFAULT_DARK_MODE);
    }

    public static void setDarkMode(Context context, boolean isDark) {
        prefs(context).edit().putBoolean(KEY_DARK_MODE, isDark).apply();
        AppCompatDelegate.setDefaultNightMode(
                isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );
    }

    private static SharedPreferences prefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
}
