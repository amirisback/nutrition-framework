package com.frogobox.nutritionapp.di

import com.frogobox.nutritionapp.mvvm.nutrition.article.NutritionArticleViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
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

val viewModelModule = module {

    viewModel {
        NutritionArticleViewModel(androidApplication(), get())
    }

}