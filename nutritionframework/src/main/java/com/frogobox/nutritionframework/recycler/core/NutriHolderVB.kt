package com.frogobox.nutritionframework.recycler.core

import androidx.viewbinding.ViewBinding

/*
 * Created by Faisal Amir on 04/02/2021
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
data class NutriHolderVB<T, VB : ViewBinding>(
    val data: T,
    val layoutBinding: VB,
    val option: Int,
    val callback: INutriBindingHolder<T, VB>,
    val listener: NutriRecyclerViewListener<T>
)