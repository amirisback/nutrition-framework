package com.frogobox.nutritionframework.recycler.core

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
interface NutriRecyclerViewListener<T> {

    // on itemview set on click listener
    fun onItemClicked(data: T)

    // on itemview set on long click listener
    fun onItemLongClicked(data: T)

}