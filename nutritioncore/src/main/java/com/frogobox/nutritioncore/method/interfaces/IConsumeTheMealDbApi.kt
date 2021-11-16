package com.frogobox.nutritioncore.method.interfaces

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
 * com.frogobox.frogomealsapi
 *
 */
interface IConsumeTheMealDbApi {

    // Search meal by name
    suspend fun searchMeal(mealName: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // List all meals by first letter
    suspend fun listAllMeal(firstLetter: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // Lookup full meal details by id
    suspend fun lookupFullMeal(idMeal: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // Lookup a single random meal
    suspend fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // List all meal categories
    suspend fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>)

    // List all Categories
    suspend fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>)

    // List all Area
    suspend fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>)

    // List all Ingredients
    suspend fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>)

    // Filter by main ingredient
    suspend fun filterByIngredient(ingredient: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Filter by Category
    suspend fun filterByCategory(category: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Filter by Area
    suspend fun filterByArea(area: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

}