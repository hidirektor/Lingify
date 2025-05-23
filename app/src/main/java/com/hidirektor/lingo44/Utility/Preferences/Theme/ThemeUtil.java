package com.hidirektor.lingo44.Utility.Preferences.Theme;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

import com.hidirektor.lingo44.Utility.SystemDefaults;

public class ThemeUtil {

    public static void setTheme(Context context, int themeMode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SystemDefaults.PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SystemDefaults.KEY_THEME, themeMode);
        editor.apply();

        AppCompatDelegate.setDefaultNightMode(themeMode);
    }

    public static void loadTheme(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SystemDefaults.PREFS_NAME, Context.MODE_PRIVATE);
        int themeMode = sharedPreferences.getInt(SystemDefaults.KEY_THEME, AppCompatDelegate.MODE_NIGHT_NO);
        setTheme(context, themeMode);
    }

    public static void changeTheme(Context context) {
        int currentMode = AppCompatDelegate.getDefaultNightMode();
        int newMode = (currentMode == AppCompatDelegate.MODE_NIGHT_NO)
                ? AppCompatDelegate.MODE_NIGHT_YES
                : AppCompatDelegate.MODE_NIGHT_NO;

        setTheme(context, newMode);
    }
}