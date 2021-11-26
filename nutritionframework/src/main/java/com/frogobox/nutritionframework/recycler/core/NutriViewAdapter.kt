package com.frogobox.nutritionframework.recycler.core

import android.view.View
import android.view.ViewGroup

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
class NutriViewAdapter<T> : NutriRecyclerViewAdapter<T>() {

    private var nutriViewHolderCallback: INutriViewHolder<T>? = null

    fun setCallback(callback: INutriViewHolder<T>) {
        nutriViewHolderCallback = callback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NutriRecyclerViewHolder<T> {
        return if (hasMultiHolder) {
            if (frogoHolder.isNotEmpty()) {
                NutriViewHolder(viewLayout(parent, frogoHolder[viewType].layoutResId), frogoHolder[viewType].callback)
            } else {
                NutriViewHolder(viewLayout(parent, emptyLayoutResId), object : INutriViewHolder<T>{
                    override fun setupInitComponent(view: View, data: T) {}
                })
            }
        } else {
            NutriViewHolder(viewLayout(parent), nutriViewHolderCallback)
        }
    }
}