package com.frogobox.nutritionapp.mvvm.nutrition.meal

import android.app.Application
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.method.function.ConsumeTheMealDbApi
import com.frogobox.nutritioncore.model.meal.Meal
import com.frogobox.nutritioncore.model.meal.MealResponse
import com.frogobox.nutritioncore.util.meal.MealUrl
import com.frogobox.nutritionframework.core.NutriViewModel
import com.frogobox.nutritionframework.util.NutriSingleLiveEvent


/*
 * Created by faisalamir on 15/11/21
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

class NutritionMealViewModel(
    private val context: Application,
    private val repository: DataRepository
) : NutriViewModel(context) {

    val listData = NutriSingleLiveEvent<List<Meal>>()
    private val consumeTheMealDbApi = ConsumeTheMealDbApi(MealUrl.API_KEY)

    fun getListMeals(firstLetter: String) {
        consumeTheMealDbApi.listAllMeal(
            firstLetter,
            object : NutriResponse.DataResponse<MealResponse<Meal>> {
                override fun onSuccess(data: MealResponse<Meal>) {
                    // on Success Request
                    data.meals?.let { listData.postValue(it) }
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    // on Failed
                    eventFailed.postValue(errorMessage)
                }

                override fun onShowProgress() {
                    // Show Your Progress View
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    // Hide Your Progress View
                    eventShowProgress.postValue(false)
                }

                override fun onEmpty() {
                    //
                }
            })
    }


}