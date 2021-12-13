package com.frogobox.nutritionapp.source


import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritionapp.source.local.LocalDataSource
import com.frogobox.nutritionapp.source.remote.RemoteDataSource
import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.model.news.ArticleResponse
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
class DataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
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
        remoteDataSource.getTopHeadline(q, sources, category, country, pageSize, page, callback)
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
        remoteDataSource.getEverythings(
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
        remoteDataSource.getSources(language, country, category, callback)
    }

    override suspend fun searchMeal(
        mealName: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        remoteDataSource.searchMeal(mealName, callback)
    }

    override suspend fun listAllMeal(
        firstLetter: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        remoteDataSource.listAllMeal(firstLetter, callback)
    }

    override suspend fun lookupFullMeal(
        idMeal: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        remoteDataSource.lookupFullMeal(idMeal, callback)
    }

    override suspend fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        remoteDataSource.lookupRandomMeal(callback)
    }

    override suspend fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>) {
        remoteDataSource.listMealCategories(callback)
    }

    override suspend fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>) {
        remoteDataSource.listAllCateories(callback)
    }

    override suspend fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>) {
        remoteDataSource.listAllArea(callback)
    }

    override suspend fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>) {
        remoteDataSource.listAllIngredients(callback)
    }

    override suspend fun filterByIngredient(
        ingredient: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        remoteDataSource.filterByIngredient(ingredient, callback)
    }

    override suspend fun filterByCategory(
        category: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        remoteDataSource.filterByCategory(category, callback)
    }

    override suspend fun filterByArea(
        area: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        remoteDataSource.filterByArea(area, callback)
    }

    override suspend fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>) {
        remoteDataSource.getVitaminA(callback)
    }

    override suspend fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>) {
        remoteDataSource.getVitaminC(callback)
    }

    override suspend fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>) {
        remoteDataSource.getVitaminE(callback)
    }

    override fun getBMI(weightKg: Double, heightCm: Double): Double {
        return remoteDataSource.getBMI(weightKg, heightCm)
    }

    override fun savePrefString(key: String, value: String) {
        localDataSource.savePrefString(key, value)
    }

    override fun savePrefLong(key: String, value: Long) {
        localDataSource.savePrefLong(key, value)
    }

    override fun savePrefFloat(key: String, value: Float) {
        localDataSource.savePrefFloat(key, value)
    }

    override fun savePrefInt(key: String, value: Int) {
        localDataSource.savePrefInt(key, value)
    }

    override fun savePrefBoolean(key: String, value: Boolean) {
        localDataSource.savePrefBoolean(key, value)
    }

    override fun deletePref(key: String) {
        localDataSource.deletePref(key)
    }

    override fun nukePref() {
        localDataSource.nukePref()
    }

    override fun getPrefString(key: String): String {
        return localDataSource.getPrefString(key)
    }

    override fun getPrefLong(key: String): Long {
        return localDataSource.getPrefLong(key)
    }

    override fun getPrefFloat(key: String): Float {
        return localDataSource.getPrefFloat(key)
    }

    override fun getPrefInt(key: String): Int {
        return localDataSource.getPrefInt(key)
    }

    override fun getPrefBoolean(key: String): Boolean {
        return localDataSource.getPrefBoolean(key)
    }

    override fun saveRoomFavorite(data: Favorite): Boolean {
        return localDataSource.saveRoomFavorite(data)
    }

    override fun getRoomFavorite(callback: DataSource.GetRoomDataCallBack<List<Favorite>>) {
        localDataSource.getRoomFavorite(callback)
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return localDataSource.updateRoomFavorite(tableId, title, description, dateTime)
    }

    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return localDataSource.deleteRoomFavorite(tableId)
    }

    override fun nukeRoomFavorite(): Boolean {
        return localDataSource.nukeRoomFavorite()
    }

}