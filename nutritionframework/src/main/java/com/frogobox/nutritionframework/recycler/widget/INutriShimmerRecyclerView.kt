package com.frogobox.nutritionframework.recycler.widget

import com.frogobox.nutritionframework.recycler.core.NutriSingleRv
import com.frogobox.nutritionframework.recycler.core.NutriSingleSrv

/*
 * Created by Faisal Amir on 02/06/2020
 * NutriRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */
 
interface INutriShimmerRecyclerView {

    // Setup SrvSingletonShimmer
    fun defineShimmerView(): NutriSingleSrv

    // Setup SrvSingletonRecycler
    fun <T> defineRecyclerView(): NutriSingleRv<T>

    // Start Shimmer Animation
    fun startShimmer()

    // Stop Shimmer Animation
    fun stopShimmer()

}