package com.frogobox.nutritionframework.recycler.core


/*
 * Created by faisalamir on 08/12/21
 * NutritionFramework
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface NutriRecyclerNotifyListener<T> {

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