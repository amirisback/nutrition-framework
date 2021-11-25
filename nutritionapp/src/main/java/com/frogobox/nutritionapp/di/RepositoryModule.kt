package com.frogobox.nutritionapp.di

import androidx.preference.PreferenceManager
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritionapp.source.local.AppDatabase
import com.frogobox.nutritionapp.source.local.LocalDataSource
import com.frogobox.nutritionapp.source.remote.RemoteDataSource
import com.frogobox.nutritioncore.method.function.ConsumeNewsApi
import com.frogobox.nutritioncore.method.function.ConsumeTheMealDbApi
import com.frogobox.nutritioncore.method.function.NutritionApi
import com.frogobox.nutritioncore.util.meal.MealUrl
import com.frogobox.nutritioncore.util.news.NewsUrl
import com.frogobox.nutritionframework.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/*
 * Created by Faisal Amir on 23/10/2020
 * KickStartProject Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

val repositoryModule = module {

    single {
        DataRepository(RemoteDataSource, get())
    }

    single {
        LocalDataSource(AppExecutors(), get(), get())
    }

    single {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }

    single {
        ConsumeNewsApi(NewsUrl.API_KEY)
    }

    single {
        ConsumeTheMealDbApi(MealUrl.API_KEY)
    }

    single {
        AppDatabase.getInstance(androidContext()).favoriteScriptDao()
    }

    single {
        NutritionApi()
    }

}