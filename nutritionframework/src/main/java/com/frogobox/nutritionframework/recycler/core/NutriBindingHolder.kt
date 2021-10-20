package com.frogobox.nutritionframework.recycler.core

import androidx.viewbinding.ViewBinding

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 26/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler
 * 
 */
class NutriBindingHolder<T, VB : ViewBinding>(
    private val binding: VB,
    private val nutriViewHolderCallback: INutriBindingHolder<T, VB>?
) :
    NutriRecyclerBindingHolder<T, VB>(binding) {

    override fun initComponent(data: T) {
        nutriViewHolderCallback?.setupInitComponent(binding, data)
    }

}