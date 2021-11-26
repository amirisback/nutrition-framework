package com.frogobox.nutritionframework.recycler.core

import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.NutriLayoutManager.dividerItemVertical
import com.frogobox.nutritionframework.recycler.core.NutriLayoutManager.gridLayout
import com.frogobox.nutritionframework.recycler.core.NutriLayoutManager.linearLayoutHorizontal
import com.frogobox.nutritionframework.recycler.core.NutriLayoutManager.linearLayoutVertical
import com.frogobox.nutritionframework.recycler.core.NutriLayoutManager.staggeredGridLayout
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant.NUTRI_RV_TAG
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView

/*
 * Created by faisalamir on 31/05/21
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
abstract class NutriSingleRvBase<T> {

    protected val listDataFH = mutableListOf<NutriHolder<T>>()
    protected val listData = mutableListOf<T>()

    protected var layoutSpanCount = 0
    protected var optionLayoutManager = ""
    protected var optionDividerItem = false
    protected var optionReverseLayout = false
    protected var optionStackFromEnd = false

    protected fun baseCreateLayoutLinearVertical(dividerItem: Boolean) {
        optionLayoutManager = NutriRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem

        NLog.d("$NUTRI_RV_TAG - injector-layoutManager : $optionLayoutManager")
        NLog.d("$NUTRI_RV_TAG - injector-divider : $optionDividerItem")
    }

    protected fun baseCreateLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ) {
        optionLayoutManager = NutriRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        NLog.d("$NUTRI_RV_TAG - injector-layoutManager : $optionLayoutManager")
        NLog.d("$NUTRI_RV_TAG - injector-divider : $optionDividerItem")
        NLog.d("$NUTRI_RV_TAG - injector-reverseLayout : $optionReverseLayout")
        NLog.d("$NUTRI_RV_TAG - injector-stackFromEnd : $optionStackFromEnd")
    }

    protected fun baseCreateLayoutLinearHorizontal(dividerItem: Boolean) {
        optionLayoutManager = NutriRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem

        NLog.d("$NUTRI_RV_TAG - injector-layoutManager : $optionLayoutManager")
        NLog.d("$NUTRI_RV_TAG - injector-divider : $optionDividerItem")
    }

    protected fun baseCreateLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ) {
        optionLayoutManager = NutriRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        NLog.d("$NUTRI_RV_TAG - injector-layoutManager : $optionLayoutManager")
        NLog.d("$NUTRI_RV_TAG - injector-divider : $optionDividerItem")
        NLog.d("$NUTRI_RV_TAG - injector-reverseLayout : $optionReverseLayout")
        NLog.d("$NUTRI_RV_TAG - injector-stackFromEnd : $optionStackFromEnd")
    }

    protected fun baseCreateLayoutStaggeredGrid(spanCount: Int) {
        optionLayoutManager = NutriRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount

        NLog.d("$NUTRI_RV_TAG - injector-layoutManager : $optionLayoutManager")
        NLog.d("$NUTRI_RV_TAG - injector-spanCount : $layoutSpanCount")
    }

    protected fun baseCreateLayoutGrid(spanCount: Int) {
        optionLayoutManager = NutriRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount

        NLog.d("$NUTRI_RV_TAG - injector-layoutManager : $optionLayoutManager")
        NLog.d("$NUTRI_RV_TAG - injector-spanCount : $layoutSpanCount")
    }

    protected fun setupLayoutManager(frogoRV: NutriRecyclerView) {

        val context = frogoRV.context

        if (listData.isNotEmpty() || listDataFH.isNotEmpty()) {

            if (optionDividerItem) {
                frogoRV.addItemDecoration(dividerItemVertical(context))
            }

            frogoRV.layoutManager = when (optionLayoutManager) {
                NutriRvConstant.LAYOUT_LINEAR_VERTICAL -> {
                    linearLayoutVertical(context)
                }

                NutriRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE -> {
                    linearLayoutVertical(context, optionReverseLayout, optionStackFromEnd)
                }

                NutriRvConstant.LAYOUT_LINEAR_HORIZONTAL -> {
                    linearLayoutHorizontal(context)
                }

                NutriRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE -> {
                    linearLayoutHorizontal(context, optionReverseLayout, optionStackFromEnd)
                }

                NutriRvConstant.LAYOUT_GRID -> {
                    gridLayout(context, layoutSpanCount)
                }

                NutriRvConstant.LAYOUT_STAGGERED_GRID -> {
                    staggeredGridLayout(layoutSpanCount)
                }

                else -> {
                    linearLayoutVertical(context)
                }
            }
        }
    }

}