package com.frogobox.nutritionapp.source.local

import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritionapp.source.local.dao.FavoriteDao
import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritionframework.core.NutriPreference
import com.frogobox.nutritionframework.util.AppExecutors
import com.frogobox.nutritionframework.util.NutriSingleFunc.noAction
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable


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
 * com.frogobox.publicspeakingbooster.source.local
 *
 */
class LocalDataSource(
    private val appExecutors: AppExecutors,
    private val sharedPreferences: NutriPreference,
    private val favoriteDao: FavoriteDao
) : DataSource {

    override fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    ) {
        noAction()
    }

    override fun getEverythings(
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
        noAction()
    }

    override fun getSources(
        language: String,
        country: String,
        category: String,
        callback: NutriResponse.DataResponse<SourceResponse>
    ) {
        noAction()
    }

    override fun searchMeal(
        mealName: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        noAction()
    }

    override fun listAllMeal(
        firstLetter: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        noAction()
    }

    override fun lookupFullMeal(
        idMeal: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {
        noAction()
    }

    override fun lookupRandomMeal(callback: NutriResponse.DataResponse<MealResponse<Meal>>) {
        noAction()
    }

    override fun listMealCategories(callback: NutriResponse.DataResponse<CategoryResponse>) {
        noAction()
    }

    override fun listAllCateories(callback: NutriResponse.DataResponse<MealResponse<Category>>) {
        noAction()
    }

    override fun listAllArea(callback: NutriResponse.DataResponse<MealResponse<Area>>) {
        noAction()
    }

    override fun listAllIngredients(callback: NutriResponse.DataResponse<MealResponse<Ingredient>>) {
        noAction()
    }

    override fun filterByIngredient(
        ingredient: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        noAction()
    }

    override fun filterByCategory(
        category: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        noAction()
    }

    override fun filterByArea(
        area: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {
        noAction()
    }

    override fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>) {
        noAction()
    }

    override fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>) {
        noAction()
    }

    override fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>) {
        noAction()
    }

    override fun getBMI(weightKg: Double, heightCm: Double): Double {
        return 0.0
    }

    override fun savePrefString(key: String, value: String) {
        sharedPreferences.savePrefString(key, value)
    }

    override fun savePrefLong(key: String, value: Long) {
        sharedPreferences.savePrefLong(key, value)
    }

    override fun savePrefFloat(key: String, value: Float) {
        sharedPreferences.savePrefFloat(key, value)
    }

    override fun savePrefInt(key: String, value: Int) {
        sharedPreferences.savePrefInt(key, value)
    }

    override fun savePrefBoolean(key: String, value: Boolean) {
        sharedPreferences.savePrefBoolean(key, value)
    }

    override fun deletePref(key: String) {
        sharedPreferences.deletePref(key)
    }

    override fun nukePref() {
        sharedPreferences.nukePref()
    }

    override fun getPrefString(key: String): String {
        return sharedPreferences.loadPrefString(key)
    }

    override fun getPrefLong(key: String): Long {
        return sharedPreferences.loadPrefLong(key)
    }

    override fun getPrefFloat(key: String): Float {
        return sharedPreferences.loadPrefFloat(key)
    }

    override fun getPrefInt(key: String): Int {
        return sharedPreferences.loadPrefInt(key)
    }

    override fun getPrefBoolean(key: String): Boolean {
        return sharedPreferences.loadPrefBoolean(key)
    }

    override fun saveRoomFavorite(data: Favorite): Boolean {
        return true
    }

    override fun getRoomFavorite(callback: DataSource.GetRoomDataCallBack<List<Favorite>>) {

    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return true
    }


    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return true
    }

    override fun nukeRoomFavorite(): Boolean {
        return true
    }

    private
    var compositeDisposable: CompositeDisposable? = null

    fun addSubscribe(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
            compositeDisposable?.add(disposable)
        }
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}
