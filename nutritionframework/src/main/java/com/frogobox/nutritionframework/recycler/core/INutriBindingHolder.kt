package com.frogobox.nutritionframework.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

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
interface INutriBindingHolder<T, VB : ViewBinding> {

    // Setup View Binding
    fun setViewBinding(parent: ViewGroup): VB

    // Setup Init Component on ViewHolder
    fun setupInitComponent(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: NutriRecyclerNotifyListener<T>
    )

}