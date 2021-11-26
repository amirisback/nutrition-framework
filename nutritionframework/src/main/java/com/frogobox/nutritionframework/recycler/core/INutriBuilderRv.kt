package com.frogobox.nutritionframework.recycler.core

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/*
 * Created by faisalamir on 23/07/21
 * NutriRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriBuilderRv<T> {

    // Setup data NutriRecyclerView
    fun setupData(): List<T>

    // Setup Custom View
    fun setupCustomView(): Int

    // Setup Empty View
    fun setupEmptyView(): Int?

    // Setup Layout Manager of NutriRecyclerView
    fun setupLayoutManager(context: Context): RecyclerView.LayoutManager

    // Setup Init Component on ViewHolder
    fun setupInitComponent(view: View, data: T)

    // Setup root item clicked
    fun onItemClicked(data: T)

    // Setup root item long clicked
    fun onItemLongClicked(data: T)

}