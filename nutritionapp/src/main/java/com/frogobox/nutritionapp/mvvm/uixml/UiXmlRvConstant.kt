package com.frogobox.nutritionapp.mvvm.uixml

import com.frogobox.nutritionapp.model.Layout
import com.frogobox.nutritionapp.R

/*
 * Created by faisalamir on 21/05/21
 * FrogoUIKit
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
object UiXmlRvConstant {
    
    const val TYPE_LIST = "List"
    const val TYPE_GRID = "Grid"

    fun dummyData(): MutableList<String> {
        val data = mutableListOf<String>()
        for (i in 1..10) {
            data.add("1")
        }
        return data
    }
    
    fun dataRvList() : MutableList<Layout> {
        val data = mutableListOf<Layout>()
        data.add(Layout("nutri_rv_list_type_1", TYPE_LIST, R.layout.nutri_rv_list_type_1))
        data.add(Layout("nutri_rv_list_type_2", TYPE_LIST, R.layout.nutri_rv_list_type_2))
        data.add(Layout("nutri_rv_list_type_3", TYPE_LIST, R.layout.nutri_rv_list_type_3))
        data.add(Layout("nutri_rv_list_type_4", TYPE_LIST, R.layout.nutri_rv_list_type_4))
        data.add(Layout("nutri_rv_list_type_5", TYPE_LIST, R.layout.nutri_rv_list_type_5))
        data.add(Layout("nutri_rv_list_type_6", TYPE_LIST, R.layout.nutri_rv_list_type_6))
        data.add(Layout("nutri_rv_list_type_7", TYPE_LIST, R.layout.nutri_rv_list_type_7))
        data.add(Layout("nutri_rv_list_type_8", TYPE_LIST, R.layout.nutri_rv_list_type_8))
        data.add(Layout("nutri_rv_list_type_9", TYPE_LIST, R.layout.nutri_rv_list_type_9))
        data.add(Layout("nutri_rv_list_type_10", TYPE_LIST, R.layout.nutri_rv_list_type_10))
        data.add(Layout("nutri_rv_list_type_11", TYPE_LIST, R.layout.nutri_rv_list_type_11))
        data.add(Layout("nutri_rv_list_type_12", TYPE_LIST, R.layout.nutri_rv_list_type_12))
        return data
    }

    fun dataRvGrid() : MutableList<Layout> {
        val data = mutableListOf<Layout>()
        data.add(Layout("nutri_rv_grid_type_1", TYPE_GRID, R.layout.nutri_rv_grid_type_1))
        data.add(Layout("nutri_rv_grid_type_2", TYPE_GRID, R.layout.nutri_rv_grid_type_2))
        data.add(Layout("nutri_rv_grid_type_3", TYPE_GRID, R.layout.nutri_rv_grid_type_3))
        data.add(Layout("nutri_rv_grid_type_4", TYPE_GRID, R.layout.nutri_rv_grid_type_4))
        data.add(Layout("nutri_rv_grid_type_5", TYPE_GRID, R.layout.nutri_rv_grid_type_5))
        data.add(Layout("nutri_rv_grid_type_6", TYPE_GRID, R.layout.nutri_rv_grid_type_6))
        data.add(Layout("nutri_rv_grid_type_7", TYPE_GRID, R.layout.nutri_rv_grid_type_7))
        return data
    }

}