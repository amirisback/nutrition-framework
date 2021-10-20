package com.frogobox.nutritionframework.recycler.core

/*
 * Created by Amir on 03/03/2021
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriNestedHolder<T> {

    // Setup Nested Custom View
    fun nestedCustomView() : Int

    // Setup Nested Listener
    fun nestedListener() : NutriRecyclerViewListener<T>

    // Setup Nested Callback
    fun nestedCallback() : INutriViewHolder<T>

}