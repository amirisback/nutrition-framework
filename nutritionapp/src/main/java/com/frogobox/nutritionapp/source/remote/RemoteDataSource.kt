package com.frogobox.nutritionapp.source.remote

import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.method.function.ConsumeNewsApi
import com.frogobox.nutritioncore.method.function.ConsumeTheMealDbApi
import com.frogobox.nutritioncore.method.function.NutritionApi
import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritionframework.util.NutriSingleFunc.noAction

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PublicSpeakingBooster
 * Copyright (C) 16/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.publicspeakingbooster.source.remote
 *
 */
class RemoteDataSource(
    private val nutritionApi: NutritionApi,
    private val consumeNewsApi: ConsumeNewsApi,
    private val consumeTheMealDbApi: ConsumeTheMealDbApi
) : DataSource {

    override suspend fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    ) {
        consumeNewsApi.getTopHeadline(q, sources, category, country, pageSize, page, callback)
    }

    override suspend fun getEverythings(
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
    ) {
        consumeNewsApi.getEverythings(
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page,
            callback
        )
    }

    override suspend fun getSources(
        language: String,
        country: String,
        category: String,
        callback: NutriResponse.DataResponse<SourceResponse>
    ) {
        consumeNewsApi.getSources(language, country, category, callback)
    }

    override suspend fun searchMeal(
        mealName: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        consumeTheMealDbApi.searchMeal(mealName, callback)
    }

    override suspend fun listAllMeal(
        firstLetter: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        consumeTheMealDbApi.listAllMeal(firstLetter, callback)
    }

    override suspend fun lookupFullMeal(
        idMeal: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        consumeTheMealDbApi.lookupFullMeal(idMeal, callback)
    }

    override suspend fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        consumeTheMealDbApi.lookupRandomMeal(callback)
    }

    override suspend fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>) {
        consumeTheMealDbApi.listMealCategories(callback)
    }

    override suspend fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>) {
        consumeTheMealDbApi.listAllCateories(callback)
    }

    override suspend fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>) {
        consumeTheMealDbApi.listAllArea(callback)
    }

    override suspend fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>) {
        consumeTheMealDbApi.listAllIngredients(callback)
    }

    override suspend fun filterByIngredient(
        ingredient: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        consumeTheMealDbApi.filterByIngredient(ingredient, callback)
    }

    override suspend fun filterByCategory(
        category: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        consumeTheMealDbApi.filterByCategory(category, callback)
    }

    override suspend fun filterByArea(
        area: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        consumeTheMealDbApi.filterByArea(area, callback)
    }

    override suspend fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>) {
        nutritionApi.getVitaminA(callback)
    }

    override suspend fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>) {
        nutritionApi.getVitaminC(callback)
    }

    override suspend fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>) {
        nutritionApi.getVitaminE(callback)
    }

    override fun getBMI(weightKg: Double, heightCm: Double): Double {
        return nutritionApi.getBMI(weightKg, heightCm)
    }

    override fun savePrefString(key: String, value: String) {
        noAction()
    }

    override fun savePrefLong(key: String, value: Long) {
        noAction()
    }

    override fun savePrefFloat(key: String, value: Float) {
        noAction()
    }

    override fun savePrefInt(key: String, value: Int) {
        noAction()
    }

    override fun savePrefBoolean(key: String, value: Boolean) {
        noAction()
    }

    override fun deletePref(key: String) {
        noAction()
    }

    override fun nukePref() {
        noAction()
    }

    override fun getPrefString(key: String): String {
        return ""
    }

    override fun getPrefLong(key: String): Long {
        return 0
    }

    override fun getPrefFloat(key: String): Float {
        return 0f
    }

    override fun getPrefInt(key: String): Int {
        return 0
    }

    override fun getPrefBoolean(key: String): Boolean {
        return false
    }

    override fun saveRoomFavorite(data: Favorite): Boolean {
        return noAction()
    }


    override fun getRoomFavorite(callback: DataSource.GetRoomDataCallBack<List<Favorite>>) {
        noAction()
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return noAction()
    }

    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return noAction()
    }

    override fun nukeRoomFavorite(): Boolean {
        return noAction()
    }


}