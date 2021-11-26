package com.frogobox.nutritionframework.recycler.core

import android.content.Context
import androidx.recyclerview.widget.*

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
interface INutriLayoutManager {

    fun linearLayoutVertical(context: Context): RecyclerView.LayoutManager

    fun linearLayoutVertical(
        context: Context,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): RecyclerView.LayoutManager

    fun linearLayoutHorizontal(context: Context): RecyclerView.LayoutManager

    fun linearLayoutHorizontal(
        context: Context,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): RecyclerView.LayoutManager

    fun dividerItemVertical(context: Context): DividerItemDecoration

    fun dividerItemHorizontal(context: Context): DividerItemDecoration

    fun staggeredGridLayout(spanCount: Int): StaggeredGridLayoutManager

    fun gridLayout(context: Context, spanCount: Int): GridLayoutManager

}