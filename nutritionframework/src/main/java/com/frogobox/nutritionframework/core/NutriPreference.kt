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

class NutriPreference(private val context: Context, private val prefName: String) {

    private val sharedPreferences by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }
    
    private val prefEditor by lazy {
        sharedPreferences.edit()
    }

    fun savePrefFloat(
        key: String,
        value: Float
    ) {
        prefEditor.putFloat(key, value).apply()
    }

    fun savePrefInt(key: String, value: Int) {
        prefEditor.putInt(key, value).apply()
    }

    fun savePrefString(
        key: String,
        value: String
    ) {
        prefEditor.putString(key, value).apply()
    }

    fun savePrefBoolean(
        key: String,
        value: Boolean
    ) {
        prefEditor.putBoolean(key, value).apply()
    }

    fun savePrefLong(key: String, value: Long) {
        prefEditor.putLong(key, value).apply()
    }

    fun deletePref(key: String) {
        prefEditor.remove(key).apply()
    }
    
    fun nukePref(){
        prefEditor.clear().apply()    
    }
    
    fun loadPrefFloat(key: String): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    fun loadPrefString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

    fun loadPrefInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun loadPrefLong(key: String): Long {
        return sharedPreferences.getLong(key, 0)
    }

    fun loadPrefBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

}