package com.frogobox.nutritionapp.di

import com.frogobox.nutritionapp.mvvm.builder.BuilderViewModel
import com.frogobox.nutritionapp.mvvm.generator.GeneratorViewModel
import com.frogobox.nutritionapp.mvvm.main.MainViewModel
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritionapp.mvvm.nutrition.meal.MealViewModel
import com.frogobox.nutritionapp.mvvm.nutrition.vitamin.VitaminViewModel
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
        ArticleViewModel(androidApplication(), get())
    }

    viewModel {
        MealViewModel(androidApplication(), get())
    }

    viewModel {
        VitaminViewModel(androidApplication(), get())
    }

    viewModel {
        MainViewModel(androidApplication(), get())
    }

    viewModel {
        BuilderViewModel(androidApplication(), get())
    }

    viewModel {
        GeneratorViewModel(androidApplication(), get())
    }

}