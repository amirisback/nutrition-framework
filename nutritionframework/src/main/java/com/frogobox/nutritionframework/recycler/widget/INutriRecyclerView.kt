package com.frogobox.nutritionframework.recycler.widget

import androidx.viewbinding.ViewBinding
import com.frogobox.nutritionframework.recycler.core.*

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 31/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.recycler.view
 *
 */

interface INutriRecyclerView {

    // Setup linear vertical recycler view
    fun isViewLinearVertical(dividerItem: Boolean)

    // Setup linear horizontal recycler view
    fun isViewLinearHorizontal(dividerItem: Boolean)

    // Setup staggered grid recycler view
    fun isViewStaggeredGrid(spanCount: Int)

    // Setup grid recycler view
    fun isViewGrid(spanCount: Int)

    // Setup SingletonRclass
    fun <T> injector(): NutriSingleRv<T>

    // Setup Singleton ViewBinding Class
    fun <T, VB : ViewBinding> injectorBinding(): NutriSingleRvBinding<T, VB>

    // Setup Builder
    fun <T> builder(listener: INutriBuilderRv<T>)

    // Setup Builder Binding
    fun <T, VB : ViewBinding> builderBinding(listener: INutriBuilderRvBinding<T, VB>)

}