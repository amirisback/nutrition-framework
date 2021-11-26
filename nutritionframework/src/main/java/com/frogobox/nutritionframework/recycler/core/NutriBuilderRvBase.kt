package com.frogobox.nutritionframework.recycler.core

import com.frogobox.nutritionframework.R
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView

/*
 * Created by faisalamir on 24/07/21
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
abstract class NutriBuilderRvBase<T> {

    protected lateinit var nutriRecyclerView: NutriRecyclerView

    protected var emptyViewId: Int = R.layout.nutri_container_empty_view

    protected var optionAdapter = ""

    protected val listDataFH = mutableListOf<NutriHolder<T>>()
    protected val listData = mutableListOf<T>()

    protected fun init(nutriRecyclerView: NutriRecyclerView) {
        this.nutriRecyclerView = nutriRecyclerView
    }

}