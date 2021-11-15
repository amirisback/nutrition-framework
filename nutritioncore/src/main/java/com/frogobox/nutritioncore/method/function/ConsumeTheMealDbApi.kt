package com.frogobox.nutritioncore.method.function

import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.method.interfaces.IConsumeTheMealDbApi
import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.sources.meal.MealRepository

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-the-meal-db-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogomealsapi
 *
 */
class ConsumeTheMealDbApi(private val apiKey: String) : IConsumeTheMealDbApi {

    private val repository = MealRepository

    override fun searchMeal(mealName: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        repository.searchMeal(apiKey, mealName, callback)
    }

    override fun listAllMeal(
        firstLetter: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        repository.listAllMeal(apiKey, firstLetter, callback)
    }

    override fun lookupFullMeal(
        idMeal: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        repository.lookupFullMeal(apiKey, idMeal, callback)
    }

    override fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        repository.lookupRandomMeal(apiKey, callback)
    }

    override fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>) {
        repository.listMealCategories(apiKey, callback)
    }

    override fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>) {
        repository.listAllCateories(apiKey, callback)
    }

    override fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>) {
        repository.listAllArea(apiKey, callback)
    }

    override fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>) {
        repository.listAllIngredients(apiKey, callback)
    }

    override fun filterByIngredient(
        ingredient: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        repository.filterByIngredient(apiKey, ingredient, callback)
    }

    override fun filterByCategory(
        category: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        repository.filterByCategory(apiKey, category, callback)
    }

    override fun filterByArea(
        area: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        repository.filterByArea(apiKey, area, callback)
    }
}