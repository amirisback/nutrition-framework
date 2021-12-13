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

    override suspend fun searchMeal(mealName: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        repository.searchMeal(apiKey, mealName, callback)
    }

    override suspend fun listAllMeal(
        firstLetter: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        repository.listAllMeal(apiKey, firstLetter, callback)
    }

    override suspend fun lookupFullMeal(
        idMeal: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        repository.lookupFullMeal(apiKey, idMeal, callback)
    }

    override suspend fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        repository.lookupRandomMeal(apiKey, callback)
    }

    override suspend fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>) {
        repository.listMealCategories(apiKey, callback)
    }

    override suspend fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>) {
        repository.listAllCateories(apiKey, callback)
    }

    override suspend fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>) {
        repository.listAllArea(apiKey, callback)
    }

    override suspend fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>) {
        repository.listAllIngredients(apiKey, callback)
    }

    override suspend fun filterByIngredient(
        ingredient: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        repository.filterByIngredient(apiKey, ingredient, callback)
    }

    override suspend fun filterByCategory(
        category: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        repository.filterByCategory(apiKey, category, callback)
    }

    override suspend fun filterByArea(
        area: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        repository.filterByArea(apiKey, area, callback)
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}