package com.frogobox.nutritioncore.method.interfaces

import com.frogobox.nutritioncore.sources.NutriResponse
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
    fun searchMeal(mealName: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // List all meals by first letter
    fun listAllMeal(firstLetter: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // Lookup full meal details by id
    fun lookupFullMeal(idMeal: String, callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // Lookup a single random meal
    fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>)

    // List all meal categories
    fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>)

    // List all Categories
    fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>)

    // List all Area
    fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>)

    // List all Ingredients
    fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>)

    // Filter by main ingredient
    fun filterByIngredient(ingredient: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Filter by Category
    fun filterByCategory(category: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Filter by Area
    fun filterByArea(area: String, callback: NutriResponse.DataResponse<MealResponse<MealFilter>>)

    // Please Add Your Code Under This Line --------------------------------------------------------

}