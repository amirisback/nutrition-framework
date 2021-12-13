package com.frogobox.nutritioncore.sources.meal

import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.util.meal.MealConstant
import com.frogobox.nutritioncore.util.meal.MealUrl
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
interface MealApiService {

    // Search meal by name
    @GET(MealUrl.URL_SEARCH_MEAL)
    fun searchMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_NAME) nameMeal: String
    ): Observable<MealResponse<Meal>>

    // List all meals by first letter
    @GET(MealUrl.URL_SEARCH_MEAL)
    fun listAllMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_FIRST_LETTER) firstLetter: String
    ): Observable<MealResponse<Meal>>

    // Lookup full meal details by id
    @GET(MealUrl.URL_LOOKUP_MEAL)
    fun lookupFullMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_ID) idMeal: String
    ): Observable<MealResponse<Meal>>

    // Lookup a single random meal
    @GET(MealUrl.URL_RANDOM_MEAL)
    fun lookupRandomMeal(
        @Path(MealConstant.PATH_API_KEY) apiKey: String
    ): Observable<MealResponse<Meal>>

    // List all meal categories
    @GET(MealUrl.URL_CATEGORIES)
    fun listMealCategories(
        @Path(MealConstant.PATH_API_KEY) apiKey: String
    ): Observable<CategoryResponse>

    // List all Categories
    @GET(MealUrl.URL_LIST)
    fun listAllCateories(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_CATEGORY) query: String
    ): Observable<MealResponse<Category>>

    // List all Area
    @GET(MealUrl.URL_LIST)
    fun listAllArea(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_AREA) query: String
    ): Observable<MealResponse<Area>>

    // List all Ingredients
    @GET(MealUrl.URL_LIST)
    fun listAllIngredients(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_INGREDIENT) query: String
    ): Observable<MealResponse<Ingredient>>

    // Filter by main ingredient
    @GET(MealUrl.URL_FILTER)
    fun filterByIngredient(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_INGREDIENT) ingredient: String
    ): Observable<MealResponse<MealFilter>>

    // Filter by Category
    fun filterByCategory(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_CATEGORY) category: String
    ): Observable<MealResponse<MealFilter>>

    // Filter by Area
    fun filterByArea(
        @Path(MealConstant.PATH_API_KEY) apiKey: String,
        @Query(MealConstant.QUERY_AREA) area: String
    ): Observable<MealResponse<MealFilter>>

    // Please Add Your Code Under This Line --------------------------------------------------------

}