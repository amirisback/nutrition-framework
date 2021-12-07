package com.frogobox.nutritionframework.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
 * Created by Amir on 03/03/2021
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
class NutriNestedHolder<T>(
    private val recyclerView: RecyclerView,
    private val nutriNestedHolderCallback: INutriNestedHolder<T>?
) : NutriRecyclerViewHolder<T>(recyclerView) {

    fun getLinearLayoutManager(): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindNestedItem(data: MutableList<T>) {
        val mAdapter = NutriViewAdapter<T>()
        mAdapter.setCallback(nutriNestedHolderCallback!!.nestedCallback())
        mAdapter.setupRequirement(
            nutriNestedHolderCallback.nestedCustomView(),
            data,
            nutriNestedHolderCallback.nestedListener()
        )
        recyclerView.adapter = mAdapter
        recyclerView.isNestedScrollingEnabled = false
        NutriStartSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun initComponent(data: T, position: Int) {}
}

