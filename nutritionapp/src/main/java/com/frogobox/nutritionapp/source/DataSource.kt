package com.frogobox.nutritionapp.source

import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 18/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.source
 *
 */
interface DataSource {

    // API Server ----------------------------------------------------------------------------------

    // Get Top Headline
    fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    )

    // Get Everythings
    fun getEverythings(
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    )

    // Get Sources
    fun getSources(
        language: String,
        country: String,
        category: String,
        callback: NutriResponse.DataResponse<SourceResponse>
    )

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

    // Get Vitamin A
    fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin C
    fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin E
    fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get BMI Kg/m2
    fun getBMI(weightKg: Double, heightCm: Double) : Double

    // Shared Preference ---------------------------------------------------------------------------

    // Save
    fun savePrefString(key: String, value: String)
    fun savePrefLong(key: String, value: Long)
    fun savePrefFloat(key: String, value: Float)
    fun savePrefInt(key: String, value: Int)
    fun savePrefBoolean(key: String, value: Boolean)

    // Delete
    fun deletePref(key: String)

    // Nuke
    fun nukePref()

    // Get
    fun getPrefString(key: String) : String
    fun getPrefLong(key: String) : Long
    fun getPrefFloat(key: String) : Float
    fun getPrefInt(key: String) : Int
    fun getPrefBoolean(key: String) : Boolean

    // Room Database -------------------------------------------------------------------------------

    fun saveRoomFavorite(data: Favorite) : Boolean

    // Get
    fun getRoomFavorite(callback: GetRoomDataCallBack<List<Favorite>>)

    // Update
    fun updateRoomFavorite(tableId: Int, title: String, description: String, dateTime: String) : Boolean

    // Delete
    fun deleteRoomFavorite(tableId: Int) : Boolean

    // Nuke
    fun nukeRoomFavorite() : Boolean
    // ---------------------------------------------------------------------------------------------

    // Interface Helper ---------------------------------------------------------------------------

    // Response Callback
    interface GetRemoteCallback<T> : NutriResponse.DataResponse<T>

    // Save
    interface SaveRoomDataCallBack<T>: NutriResponse.DataResponse<T>
    interface SavePrefCallBack<T>: NutriResponse.DataResponse<T>

    // Get
    interface GetRoomDataCallBack<T> : NutriResponse.DataResponse<T>

    // Update
    interface UpdateRoomDataCallBack<T> : NutriResponse.DataResponse<T>

    // Delete
    interface DeleteRoomDataCallBack<T> : NutriResponse.DataResponse<T>
    // ---------------------------------------------------------------------------------------------

    // Please Add Your Code Under This Line --------------------------------------------------------

}