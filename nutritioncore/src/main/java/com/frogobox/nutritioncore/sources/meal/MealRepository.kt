package com.frogobox.nutritioncore.sources.meal

import com.frogobox.nutritioncore.sources.NutriApiClient
import com.frogobox.nutritioncore.sources.NutriApiObserver
import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.meal.*
import com.frogobox.nutritioncore.util.meal.MealConstant
import com.frogobox.nutritioncore.util.meal.MealUrl
import io.reactivex.schedulers.Schedulers

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
object MealRepository : MealDataSource {

    private val TAG = MealRepository::class.java.simpleName
    private var mealApiService = NutriApiClient.create<MealApiService>(MealUrl.BASE_URL, true)

    override fun searchMeal(
        apiKey: String,
        mealName: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {

        mealApiService
            .searchMeal(apiKey, mealName)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })

    }

    override fun listAllMeal(
        apiKey: String,
        firstLetter: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {

        mealApiService
            .listAllMeal(apiKey, firstLetter)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {

        mealApiService
            .lookupFullMeal(apiKey, idMeal)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun lookupRandomMeal(
        apiKey: String,
        callback: NutriResponse.DataResponse<MealResponse<Meal>>
    ) {

        mealApiService
            .lookupRandomMeal(apiKey)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Meal>>() {
                override fun onSuccess(data: MealResponse<Meal>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun listMealCategories(
        apiKey: String,
        callback: NutriResponse.DataResponse<CategoryResponse>
    ) {

        mealApiService
            .listMealCategories(apiKey)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<CategoryResponse>() {
                override fun onSuccess(data: CategoryResponse) {
                    if (data.categories?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun listAllCateories(
        apiKey: String,
        callback: NutriResponse.DataResponse<MealResponse<Category>>
    ) {

        mealApiService
            .listAllCateories(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Category>>() {
                override fun onSuccess(data: MealResponse<Category>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun listAllArea(
        apiKey: String,
        callback: NutriResponse.DataResponse<MealResponse<Area>>
    ) {

        mealApiService
            .listAllArea(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Area>>() {
                override fun onSuccess(data: MealResponse<Area>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }


            })
    }

    override fun listAllIngredients(
        apiKey: String,
        callback: NutriResponse.DataResponse<MealResponse<Ingredient>>
    ) {

        mealApiService
            .listAllIngredients(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<Ingredient>>() {
                override fun onSuccess(data: MealResponse<Ingredient>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun filterByIngredient(
        apiKey: String,
        ingredient: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {

        mealApiService
            .filterByIngredient(apiKey, ingredient)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<MealFilter>>() {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun filterByCategory(
        apiKey: String,
        category: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {

        mealApiService
            .filterByCategory(apiKey, category)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<MealFilter>>() {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun filterByArea(
        apiKey: String,
        area: String,
        callback: NutriResponse.DataResponse<MealResponse<MealFilter>>
    ) {

        mealApiService
            .filterByArea(apiKey, area)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<MealResponse<MealFilter>>() {
                override fun onSuccess(data: MealResponse<MealFilter>) {
                    if (data.meals?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}