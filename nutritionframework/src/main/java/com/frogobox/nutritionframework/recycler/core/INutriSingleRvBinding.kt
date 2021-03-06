package com.frogobox.nutritionframework.recycler.core

import androidx.viewbinding.ViewBinding
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 27/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.util
 * 
 */
interface INutriSingleRvBinding<T, VB : ViewBinding> {

    // Init NutriRecyclerView
    fun initSingleton(nutriRecyclerView: NutriRecyclerView): NutriSingleRvBinding<T, VB>

    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean): NutriSingleRvBinding<T, VB>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRvBinding<T, VB>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean): NutriSingleRvBinding<T, VB>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRvBinding<T, VB>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int): NutriSingleRvBinding<T, VB>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int): NutriSingleRvBinding<T, VB>

    // Adding Data for RecyclerView
    fun addData(listData: List<T>): NutriSingleRvBinding<T, VB>

    // Adding Callback for adapter
    fun addCallback(nutriViewAdapterCallback: INutriBindingAdapter<T, VB>): NutriSingleRvBinding<T, VB>

    // Build this NutriRecyclerView
    fun build(): NutriSingleRvBinding<T, VB>

    // ---------------------------------------------------------------------------------------------

    // Notify Data List
    fun nutriNotifyData() : MutableList<T>

    // Notify Data Set Changed
    fun nutriNotifyDataSetChanged()

    // Notify Data Item Changed
    fun nutriNotifyItemChanged(data: T, position: Int, payload: Any)

    // Notify Data Item Changed
    fun nutriNotifyItemChanged(data: T, position: Int)

    // Notify Data Item Inserted
    fun nutriNotifyItemInserted(data: T, position: Int)

    // Notify Data Item Moved
    fun nutriNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int)

    // Notify Data Item Range Changed
    fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any)

    // Notify Data Item Range Changed
    fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int)

    // Notify Data Item Range Inserted
    fun nutriNotifyItemRangeInserted(data: List<T>, positionStart: Int)

    // Notify Data Item Range Removed
    fun nutriNotifyItemRangeRemoved(positionStart: Int, itemCount: Int)

    // Notify Data Item Removed
    fun nutriNotifyItemRemoved(position: Int)

}