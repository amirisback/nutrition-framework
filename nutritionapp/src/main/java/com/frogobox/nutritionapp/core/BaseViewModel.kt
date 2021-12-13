package com.frogobox.nutritionapp.core

import android.app.Application
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritionframework.core.NutriViewModel


/*
 * Created by faisalamir on 08/12/21
 * NutritionFramework
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

abstract class BaseViewModel (
    private val context: Application,
    private val repository: DataRepository
) : NutriViewModel(context) {

    fun savePrefString(key: String, value: String) {
        repository.savePrefString(key, value)
    }

    fun savePrefLong(key: String, value: Long) {
        repository.savePrefLong(key, value)
    }

    fun savePrefFloat(key: String, value: Float) {
        repository.savePrefFloat(key, value)
    }

    fun savePrefInt(key: String, value: Int) {
        repository.savePrefInt(key, value)
    }

    fun savePrefBoolean(key: String, value: Boolean) {
        repository.savePrefBoolean(key, value)
    }

    fun deletePref(key: String) {
        repository.deletePref(key)
    }

    fun nukePref() {
        repository.nukePref()
    }

    fun getPrefString(key: String): String {
        return repository.getPrefString(key)
    }

    fun getPrefLong(key: String): Long {
        return repository.getPrefLong(key)
    }

    fun getPrefFloat(key: String): Float {
        return repository.getPrefFloat(key)
    }

    fun getPrefInt(key: String): Int {
        return repository.getPrefInt(key)
    }

    fun getPrefBoolean(key: String): Boolean {
        return repository.getPrefBoolean(key)
    }

    // Please Add Your Code Under This Line --------------------------------------------------------


}