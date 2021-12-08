package com.frogobox.nutritionapp.mvvm.generator

import android.app.Application
import android.content.Intent
import com.frogobox.nutritionapp.core.BaseViewModel
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.mvvm.main.AndroidMethodActivity
import com.frogobox.nutritionapp.mvvm.main.UiComponentActivity
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleCategoryActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.BeratBadanIdealActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.IndexMasaTubuhActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.KebutuhanEnergiActivity
import com.frogobox.nutritionapp.mvvm.nutrition.meal.MealActivity
import com.frogobox.nutritionapp.mvvm.nutrition.vitamin.VitaminActivity
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

class GeneratorViewModel(
    private val context: Application,
    private val repository: DataRepository
) : BaseViewModel(context, repository) {

    var listDataMenu = NutriSingleLiveEvent<MutableList<Menu>>()

    fun setupDataMenu() {
        val data = mutableListOf<Menu>()

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_NUTRITION_ARTICLE)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE,
                    intentArticle(
                        Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE,
                        Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE_DETAIL,
                        "Nutrisi"
                    )
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE,
                    intentArticle(
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE,
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_DETAIL,
                        "Vitamin"
                    )
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE_A)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_A,
                    intentVitamin(
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_A,
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_DETAIL,
                        Constant.Const.CONS_VITAMIN_A
                    )
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE_C)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_C,
                    intentVitamin(
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_C,
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_DETAIL,
                        Constant.Const.CONS_VITAMIN_C
                    )
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_VITAMIN_ARTICLE_E)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_E,
                    intentVitamin(
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_E,
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_DETAIL,
                        Constant.Const.CONS_VITAMIN_E
                    )
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_CALORIE_ARTICLE)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_CALORIE_ARTICLE,
                    intentArticle(
                        Constant.TitleActivity.ACTIVITY_CALORIE_ARTICLE,
                        Constant.TitleActivity.ACTIVITY_CALORIE_ARTICLE_DETAIL,
                        "Kalori"
                    )
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_UI_COMPONENT)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_UI_COMPONENT,
                    Intent(context, UiComponentActivity::class.java)
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_ANDROID_METHOD)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_ANDROID_METHOD,
                    Intent(context, AndroidMethodActivity::class.java)
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_MEAL)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_MEAL,
                    Intent(context, MealActivity::class.java)
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI,
                    Intent(context, KebutuhanEnergiActivity::class.java)
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH,
                    Intent(context, IndexMasaTubuhActivity::class.java)
                )
            )
        }

        if (getPrefBoolean(Constant.SharedPref.KEY_PREF_ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL)) {
            data.add(
                Menu(
                    Constant.TitleActivity.ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL,
                    Intent(context, BeratBadanIdealActivity::class.java)
                )
            )
        }

        listDataMenu.postValue(data)
    }

    private fun intentArticle(title: String, titleDetail: String, query: String): Intent {
        return Intent(context, ArticleCategoryActivity::class.java)
            .putExtra(Constant.Extra.EXTRA_ARTICLE_TITLE, title)
            .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE, titleDetail)
            .putExtra(Constant.Extra.EXTRA_ARTICLE, query)
    }

    private fun intentVitamin(title: String, titleDetail: String, query: String): Intent {
        return Intent(context, VitaminActivity::class.java)
            .putExtra(Constant.Extra.EXTRA_ARTICLE_TITLE, title)
            .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE, titleDetail)
            .putExtra(Constant.Extra.EXTRA_ARTICLE, query)
    }

}