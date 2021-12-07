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
        constPref: String,
        data: Float
    ) {
        prefEditor.putFloat(constPref, data).apply()
    }

    fun savePrefInt(constPref: String, data: Int) {
        prefEditor.putInt(constPref, data).apply()
    }

    fun savePrefString(
        constPref: String,
        data: String
    ) {
        prefEditor.putString(constPref, data).apply()
    }

    fun savePrefBoolean(
        constPref: String,
        data: Boolean
    ) {
        prefEditor.putBoolean(constPref, data).apply()
    }

    fun savePrefLong(constPref: String, data: Long) {
        prefEditor.putLong(constPref, data).apply()
    }

    fun deletePref(constPref: String) {
        prefEditor.remove(constPref).apply()
    }
    
    fun nukePref(){
        prefEditor.clear().apply()    
    }
    
    fun loadPrefFloat(constPref: String): Float {
        return sharedPreferences.getFloat(constPref, 0f)
    }

    fun loadPrefString(constPref: String): String {
        return sharedPreferences.getString(constPref, "")!!
    }

    fun loadPrefInt(constPref: String): Int {
        return sharedPreferences.getInt(constPref, 0)
    }

    fun loadPrefLong(constPref: String): Long {
        return sharedPreferences.getLong(constPref, 0)
    }

    fun loadPrefBoolean(constPref: String): Boolean {
        return sharedPreferences.getBoolean(constPref, false)
    }

}