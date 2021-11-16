package com.frogobox.nutritioncore.sources.meal

import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.model.meal.*


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
 * com.frogobox.frogomealsapi.data.source
 *
 */
interface MealDataSource {

    // Search meal by name
    suspend fun searchMeal(apiKey: String, mealName: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // List all meals by first letter
    suspend fun listAllMeal(apiKey: String, firstLetter: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // Lookup full meal details by id
    suspend fun lookupFullMeal(apiKey: String, idMeal: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // Lookup a single random meal
    suspend fun lookupRandomMeal(apiKey: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // List all meal categories
    suspend fun listMealCategories(apiKey: String, callback: NutriResponse.DataResponse<CategoryResponse>)

    // List all Categories
    suspend fun listAllCateories(apiKey: String, callback: NutriResponse.DataResponse<MealResponse<Category>>)

    // List all Area
    suspend fun listAllArea(apiKey: String, callback: NutriResponse.DataResponse<MealResponse<Area>>)

    // List all Ingredients
    suspend fun listAllIngredients(apiKey: String, callback: NutriResponse.DataResponse<MealResponse<Ingredient>>)

    // Filter by main ingredient
    suspend fun filterByIngredient(apiKey: String, ingredient: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Filter by Category
    suspend fun filterByCategory(apiKey: String, category: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Filter by Area
    suspend fun filterByArea(apiKey: String, area: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)


}