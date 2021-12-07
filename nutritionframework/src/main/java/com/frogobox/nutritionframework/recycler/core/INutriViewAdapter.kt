package com.frogobox.nutritionframework.recycler.core

import android.view.View

/*
 * Created by Faisal Amir
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 14/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.callback
 * 
 */
interface INutriViewAdapter<T> {

    // Setup Init Component on ViewHolder
    fun setupInitComponent(view: View, data: T, position: Int)

    // Setup item clicked
    fun onItemClicked(view: View, data: T, position: Int)

    // Setup item long clicked
    fun onItemLongClicked(view: View, data: T, position: Int)

}