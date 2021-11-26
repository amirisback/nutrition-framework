package com.frogobox.nutritionframework.recycler.core

import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 27/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.util
 * 
 */
interface INutriSingleRv<T> {

    // Init NutriRecyclerView
    fun initSingleton(nutriRecyclerView: NutriRecyclerView): NutriSingleRv<T>
    
    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean): NutriSingleRv<T>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRv<T>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean): NutriSingleRv<T>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRv<T>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int): NutriSingleRv<T>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int): NutriSingleRv<T>
    
    // Adding Data for RecyclerView
    fun addData(listData: List<T>): NutriSingleRv<T>

    // Adding Data with object ViewHolder
    fun addDataFH(listDataFH: List<NutriHolder<T>>): NutriSingleRv<T>

    // Adding Custom View for RecyclerView
    fun addCustomView(customViewInt: Int): NutriSingleRv<T>

    // Adding Empty View layout if data is Empty
    fun addEmptyView(emptyViewInt: Int?): NutriSingleRv<T>

    // Adding Callback for adapter
    fun addCallback(nutriViewAdapterCallback: INutriViewAdapter<T>): NutriSingleRv<T>

    // Build this NutriRecyclerView
    fun build(): NutriSingleRv<T>

}