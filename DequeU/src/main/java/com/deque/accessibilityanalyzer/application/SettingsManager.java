package com.deque.accessibilityanalyzer.application;

import android.content.Context;
import android.content.SharedPreferences;

import com.deque.accessibilityanalyzer.BuildConfig;

/**
 * Created by melinda.kothbauer@deque.com on 7/28/15.
 * This class manages the settings for individual rules for the Settings Activity
 */
public class SettingsManager {

    private SettingsManager() {}

    private static final String PREFS_FILE_NAME = BuildConfig.APPLICATION_ID + ".preferences";

    public enum Ints {
        WEB_SOCKET_PORT_NUMBER(48484);

        final int mDefaultValue;


        Ints(int defaultValue) {
            mDefaultValue = defaultValue;
        }

        public int getValue() {
            return mSharedPreferences.getInt(name(), mDefaultValue);
        }

        @SuppressWarnings("unused")
        public void setValue(final int value) {
            mSharedPreferences.edit().putInt(name(), value).apply();
        }
    }

    private static SharedPreferences mSharedPreferences;

    public static void initialize(final Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, 0);
        }
    }
}
