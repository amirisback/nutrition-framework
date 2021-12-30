package com.frogobox.nutritionapp.mvvm.main.builder

import android.app.Application
import com.frogobox.nutritionapp.core.BaseViewModel
import com.frogobox.nutritionapp.model.BuilderRes
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritionapp.util.Constant
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
) : BaseViewModel(context, repository) {

    var listDataBuilderRes = NutriSingleLiveEvent<MutableList<BuilderRes>>()

    fun setupDataBuilderRes() {
        val listBuilderRes = mutableListOf<BuilderRes>()

        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_CALORIE_ARTICLE, Constant.SharedPref.KEY_PREF_ACTIVITY_CALORIE_ARTICLE, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE, Constant.SharedPref.KEY_PREF_ACTIVITY_NUTRITION_ARTICLE, false))

        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE, Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_A, Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE_A, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_C, Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE_C, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_E, Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE_E, false))

        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI, Constant.SharedPref.KEY_PREF_ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH, Constant.SharedPref.KEY_PREF_ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL, Constant.SharedPref.KEY_PREF_ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL, false))

        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_UI_COMPONENT, Constant.SharedPref.KEY_PREF_ACTIVITY_UI_COMPONENT, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD, Constant.SharedPref.KEY_PREF_ACTIVITY_ANDROID_METHOD, false))
        listBuilderRes.add(BuilderRes(Constant.TitleActivity.ACTIVITY_MEAL, Constant.SharedPref.KEY_PREF_ACTIVITY_MEAL, false))
        
        listDataBuilderRes.postValue(listBuilderRes)
    }

    fun savePrefBuilder() {
        repository.savePrefBoolean(Constant.SharedPref.KEY_PREF_BUILDER, true)
    }

    fun savePrefItemBuilder(list: MutableList<BuilderRes>) {
        for (i in list.indices) {
            if (list[i].value) {
                repository.savePrefBoolean(list[i].key, list[i].value)
            }
        }
    }

    fun getPrefBuilder(): Boolean {
        return repository.getPrefBoolean(Constant.SharedPref.KEY_PREF_BUILDER)
    }

}