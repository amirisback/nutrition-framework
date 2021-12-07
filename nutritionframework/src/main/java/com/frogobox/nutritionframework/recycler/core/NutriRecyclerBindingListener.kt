package com.frogobox.nutritionframework.recycler.core

import android.view.View
import androidx.viewbinding.ViewBinding


/*
 * Created by faisalamir on 07/12/21
 * NutritionFramework
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface NutriRecyclerBindingListener<T, VB: ViewBinding> {

    // on itemview set on click listener
    fun onItemClicked(binding: VB, data: T, position: Int)

    // on itemview set on long click listener
    fun onItemLongClicked(binding: VB, data: T, position: Int)


}