package com.frogobox.nutritionframework.recycler.widget

import android.content.res.TypedArray
import android.widget.ProgressBar

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
interface INutriStyleComponent {

    // Setup Component Frogo Recycler View
    fun setupComponentNutriRecyclerView(typedArray: TypedArray, nutriRecyclerView: NutriRecyclerView)

    // Setup Component Frogo Progress Bar
    fun setupComponentProgressBar(typedArray: TypedArray, progressBar: ProgressBar)

}