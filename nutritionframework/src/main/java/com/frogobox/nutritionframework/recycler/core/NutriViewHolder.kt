package com.frogobox.nutritionframework.recycler.core

import android.view.View

/*
 * Created by Faisal Amir
 * =========================================
 * NutriRecyclerViewAdapter
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
class NutriViewHolder<T>(view: View, private val nutriViewHolderCallback: INutriViewHolder<T>?) :
    NutriRecyclerViewHolder<T>(view) {

    override fun initComponent(data: T) {
        nutriViewHolderCallback?.setupInitComponent(itemView, data)
    }

}