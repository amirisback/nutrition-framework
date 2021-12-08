package com.frogobox.nutritionapp.mvvm.builder

import android.app.Application
import com.frogobox.nutritionapp.model.BuilderRes
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.core.NutriViewModel
import com.frogobox.nutritionframework.util.NutriSingleLiveEvent


/*
 * Created by faisalamir on 07/12/21
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

class BuilderViewModel(
    private val context: Application,
    private val repository: DataRepository
) : NutriViewModel(context) {

    var listDataBuilderRes = NutriSingleLiveEvent<MutableList<BuilderRes>>()

    fun setupDataBuilderRes() {
        val listBuilderRes = mutableListOf<BuilderRes>()
        listBuilderRes.add(BuilderRes("Vitamin A", "NameApp", "Vitamin A", false))
        listBuilderRes.add(BuilderRes("Vitamin C", "NameApp", "Vitamin C", false))
        listBuilderRes.add(BuilderRes("Vitamin E", "NameApp", "Vitamin E", false))
        listDataBuilderRes.postValue(listBuilderRes)
    }

    fun savePrefBuilder() {
        repository.savePrefBoolean(Constant.SharedPref.KEY_PREF_BUILDER, true)
    }

    fun getPrefBuilder(): Boolean {
        return repository.getPrefBoolean(Constant.SharedPref.KEY_PREF_BUILDER)
    }

}