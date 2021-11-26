package com.frogobox.nutritionframework.recycler.widget

import com.frogobox.nutritionframework.recycler.core.NutriSingleRv

/*
 * Created by faisalamir on 09/05/21
 * NutriRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriProgressRecyclerView {

    // Setup RvSingletonRecycler
    fun <T> defineRecyclerView(): NutriSingleRv<T>

    // Show Progress View
    fun showProgress()

    // Hide Progress View
    fun hideProgress()

}