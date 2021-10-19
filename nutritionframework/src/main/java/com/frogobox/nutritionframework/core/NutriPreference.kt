package com.frogobox.nutritionframework.core

import android.content.Context
import android.content.SharedPreferences

/*
 * Created by faisalamir on 26/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

object NutriPreference {

    fun getSp(context: Context, prefName: String): SharedPreferences {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    object Save {
        fun savePrefFloat(
            sharedPreferences: SharedPreferences,
            constPref: String,
            data: Float
        ) {
            sharedPreferences.edit().putFloat(constPref, data).apply()
        }

        fun savePrefInt(sharedPreferences: SharedPreferences, constPref: String, data: Int) {
            sharedPreferences.edit().putInt(constPref, data).apply()
        }

        fun savePrefString(
            sharedPreferences: SharedPreferences,
            constPref: String,
            data: String
        ) {
            sharedPreferences.edit().putString(constPref, data).apply()
        }

        fun savePrefBoolean(
            sharedPreferences: SharedPreferences,
            constPref: String,
            data: Boolean
        ) {
            sharedPreferences.edit().putBoolean(constPref, data).apply()
        }

        fun savePrefLong(sharedPreferences: SharedPreferences, constPref: String, data: Long) {
            sharedPreferences.edit().putLong(constPref, data).apply()
        }

    }

    object Delete {

        fun deletePref(sharedPreferences: SharedPreferences, constPref: String) {
            sharedPreferences.edit().remove(constPref).apply()
        }

    }

    object Load {

        fun loadPrefFloat(sharedPreferences: SharedPreferences, constPref: String): Float {
            return sharedPreferences.getFloat(constPref, 0f)
        }

        fun loadPrefString(sharedPreferences: SharedPreferences, constPref: String): String {
            return sharedPreferences.getString(constPref, "")!!
        }

        fun loadPrefInt(sharedPreferences: SharedPreferences, constPref: String): Int {
            return sharedPreferences.getInt(constPref, 0)
        }

        fun loadPrefLong(sharedPreferences: SharedPreferences, constPref: String): Long {
            return sharedPreferences.getLong(constPref, 0)
        }

        fun loadPrefBoolean(sharedPreferences: SharedPreferences, constPref: String): Boolean {
            return sharedPreferences.getBoolean(constPref, false)
        }

    }

}