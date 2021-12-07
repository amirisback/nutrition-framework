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
    
    fun nutriNotifyDataSetChanged()
    
    fun nutriNotifyItemChanged(data: T, position: Int, payload: Any)
    
    fun nutriNotifyItemChanged(data: T, position: Int)
    
    fun nutriNotifyItemInserted(data: T, position: Int)
    
    fun nutriNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int)
    
    fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any)
    
    fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int)
    
    fun nutriNotifyItemRangeInserted(data: List<T>, positionStart: Int)
    
    fun nutriNotifyItemRangeRemoved(positionStart: Int, itemCount: Int)
    
    fun nutriNotifyItemRemoved(position: Int)

}