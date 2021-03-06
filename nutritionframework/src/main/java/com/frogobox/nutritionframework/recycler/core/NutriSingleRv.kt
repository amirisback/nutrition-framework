package com.frogobox.nutritionframework.recycler.core

import android.view.View
import com.frogobox.nutritionframework.R
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant.NUTRI_RV_TAG
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
                override fun setupInitComponent(
                    view: View,
                    data: T,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<T>
                ) {
                    nutriAdapterCallback.setupInitComponent(view, data, position, notifyListener)
                }
            })

            nutriViewAdapter.setupRequirement(customViewId, listData,
                object :
                    NutriRecyclerViewListener<T> {
                    override fun onItemClicked(
                        view: View,
                        data: T,
                        position: Int,
                        notifyListener: NutriRecyclerNotifyListener<T>
                    ) {
                        nutriAdapterCallback.onItemClicked(view, data, position, notifyListener)
                    }

                    override fun onItemLongClicked(
                        view: View,
                        data: T,
                        position: Int,
                        notifyListener: NutriRecyclerNotifyListener<T>
                    ) {
                        nutriAdapterCallback.onItemLongClicked(view, data, position, notifyListener)
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

    override fun nutriNotifyData(): MutableList<T> {
        return nutriViewAdapter.innerNutriNotifyData()
    }

    override fun nutriNotifyDataSetChanged() {
        nutriViewAdapter.innerNutriNotifyDataSetChanged()
    }

    override fun nutriNotifyItemChanged(data: T, position: Int, payload: Any) {
        nutriViewAdapter.innerNutriNotifyItemChanged(data, position, payload)
    }

    override fun nutriNotifyItemChanged(data: T, position: Int) {
        nutriViewAdapter.innerNutriNotifyItemChanged(data, position)
    }

    override fun nutriNotifyItemInserted(data: T, position: Int) {
        nutriViewAdapter.innerNutriNotifyItemInserted(data, position)
    }

    override fun nutriNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        nutriViewAdapter.innerNutriNotifyItemMoved(data, fromPosition, toPosition)
    }

    override fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        nutriViewAdapter.innerNutriNotifyItemRangeChanged(data, positionStart, payload)
    }

    override fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        nutriViewAdapter.innerNutriNotifyItemRangeChanged(data, positionStart)
    }

    override fun nutriNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        nutriViewAdapter.innerNutriNotifyItemRangeInserted(data, positionStart)
    }

    override fun nutriNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        nutriViewAdapter.innerNutriNotifyItemRangeRemoved(positionStart, itemCount)
    }

    override fun nutriNotifyItemRemoved(position: Int) {
        nutriViewAdapter.innerNutriNotifyItemRemoved(position)
    }

}