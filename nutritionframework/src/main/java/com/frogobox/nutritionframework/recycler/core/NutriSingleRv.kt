package com.frogobox.nutritionframework.recycler.core

import android.view.View
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.R
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant.NUTRI_RV_TAG
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 27/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler
 *
 */
open class NutriSingleRv<T> : NutriSingleRvBase<T>(), INutriSingleRv<T> {

    protected lateinit var nutriRecycleView: NutriRecyclerView
    protected lateinit var nutriAdapterCallback: INutriViewAdapter<T>
    protected lateinit var nutriViewAdapter: NutriViewAdapter<T>

    protected var emptyViewId: Int = R.layout.nutri_container_empty_view

    protected var optionAdapter = ""
    protected var customViewId: Int = 0
    
    override fun initSingleton(nutriRecyclerView: NutriRecyclerView): NutriSingleRv<T> {
        nutriRecycleView = nutriRecyclerView
        nutriViewAdapter = NutriViewAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): NutriSingleRv<T> {
        baseCreateLayoutLinearVertical(dividerItem)
        return this
    }

    override fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRv<T> {
        baseCreateLayoutLinearVertical(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): NutriSingleRv<T> {
        baseCreateLayoutLinearHorizontal(dividerItem)
        return this
    }

    override fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRv<T> {
        baseCreateLayoutLinearHorizontal(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): NutriSingleRv<T> {
        baseCreateLayoutStaggeredGrid(spanCount)
        return this
    }

    override fun createLayoutGrid(spanCount: Int): NutriSingleRv<T> {
        baseCreateLayoutGrid(spanCount)
        return this
    }

    override fun addData(listData: List<T>): NutriSingleRv<T> {
        this.listData.addAll(listData)
        NLog.d("$NUTRI_RV_TAG - injector-listData : ${this.listData.size}")
        return this
    }

    override fun addDataFH(listDataFH: List<NutriHolder<T>>): NutriSingleRv<T> {
        this.listDataFH.addAll(listDataFH)
        nutriViewAdapter.setupMultiHolder()
        NLog.d("$NUTRI_RV_TAG - injector-listData : ${this.listDataFH.size}")
        return this
    }

    override fun addCustomView(customViewInt: Int): NutriSingleRv<T> {
        this.customViewId = customViewInt
        NLog.d("$NUTRI_RV_TAG - injector-customView : $customViewId")
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): NutriSingleRv<T> {
        if (emptyViewInt != null) this.emptyViewId = emptyViewInt
        NLog.d("$NUTRI_RV_TAG - injector-emptyView : $emptyViewId")
        return this
    }

    override fun addCallback(nutriViewAdapterCallback: INutriViewAdapter<T>): NutriSingleRv<T> {
        this.nutriAdapterCallback = nutriViewAdapterCallback
        NLog.d("$NUTRI_RV_TAG - injector-adaptCallback : $nutriAdapterCallback")
        return this
    }

    protected open fun createAdapter() {

        if (nutriViewAdapter.hasMultiHolder) {
            optionAdapter = NutriRvConstant.NUTRI_ADAPTER_MULTI
            nutriViewAdapter.setupRequirement(listDataFH)
            nutriViewAdapter.setupEmptyView(emptyViewId)

        } else {
            optionAdapter = NutriRvConstant.NUTRI_ADAPTER_R_CLASS
            nutriViewAdapter.setCallback(object : INutriViewHolder<T> {
                override fun setupInitComponent(view: View, data: T) {
                    nutriAdapterCallback.setupInitComponent(view, data)
                }
            })

            nutriViewAdapter.setupRequirement(customViewId, listData,
                object :
                    NutriRecyclerViewListener<T> {
                    override fun onItemClicked(data: T) {
                        nutriAdapterCallback.onItemClicked(data)
                    }

                    override fun onItemLongClicked(data: T) {
                        nutriAdapterCallback.onItemLongClicked(data)
                    }
                })
            nutriViewAdapter.setupEmptyView(emptyViewId)

        }
    }

    protected open fun setupInnerAdapter() {
        NLog.d("$NUTRI_RV_TAG - injector-optionAdapter : $optionAdapter")
        nutriRecycleView.adapter = nutriViewAdapter
    }

    override fun build(): NutriSingleRv<T> {
        createAdapter()
        setupLayoutManager(nutriRecycleView)
        setupInnerAdapter()
        return this
    }

}