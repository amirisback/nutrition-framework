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
 * com.frogobox.recycler.content
 * 
 */
class NutriBindingAdapter<T, VB : ViewBinding> : NutriRecyclerBindingAdapter<T, VB>() {

    private var nutriViewHolderCallback: INutriBindingHolder<T, VB>? = null

    fun setCallback(callback: INutriBindingHolder<T, VB>) {
        nutriViewHolderCallback = callback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NutriRecyclerBindingHolder<T, VB> {
        return NutriBindingHolder(nutriViewHolderCallback!!.setViewBinding(parent), nutriViewHolderCallback)
    }
}