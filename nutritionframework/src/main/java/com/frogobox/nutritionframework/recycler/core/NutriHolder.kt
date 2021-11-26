package com.frogobox.nutritionframework.recycler.core

/*
 * Created by Faisal Amir on 04/02/2021
 * NutriRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
data class NutriHolder<T>(
    val data: T,
    val layoutResId: Int,
    val option: Int,
    val callback: INutriViewHolder<T>,
    val listener: NutriRecyclerViewListener<T>
)