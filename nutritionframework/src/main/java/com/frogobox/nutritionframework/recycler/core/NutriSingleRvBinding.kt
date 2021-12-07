package com.frogobox.nutritionframework.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
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
open class NutriSingleRvBinding<T, VB : ViewBinding> : NutriSingleRvBase<T>(),
    INutriSingleRvBinding<T, VB> {

    protected lateinit var nutriRecycleView: NutriRecyclerView
    protected lateinit var nutriAdapterCallback: INutriBindingAdapter<T, VB>
    protected lateinit var nutriViewAdapter: NutriBindingAdapter<T, VB>

    protected var optionAdapter = ""

    override fun initSingleton(nutriRecyclerView: NutriRecyclerView): NutriSingleRvBinding<T, VB> {
        nutriRecycleView = nutriRecyclerView
        nutriViewAdapter = NutriBindingAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): NutriSingleRvBinding<T, VB> {
        baseCreateLayoutLinearVertical(dividerItem)
        return this
    }

    override fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRvBinding<T, VB> {
        baseCreateLayoutLinearVertical(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): NutriSingleRvBinding<T, VB> {
        baseCreateLayoutLinearHorizontal(dividerItem)
        return this
    }

    override fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): NutriSingleRvBinding<T, VB> {
        baseCreateLayoutLinearHorizontal(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): NutriSingleRvBinding<T, VB> {
        baseCreateLayoutStaggeredGrid(spanCount)
        return this
    }

    override fun createLayoutGrid(spanCount: Int): NutriSingleRvBinding<T, VB> {
        baseCreateLayoutGrid(spanCount)
        return this
    }

    override fun addData(listData: List<T>): NutriSingleRvBinding<T, VB> {
        this.listData.addAll(listData)
        NLog.d("$NUTRI_RV_TAG - injector-listData : ${this.listData.size}")
        return this
    }


    override fun addCallback(nutriViewAdapterCallback: INutriBindingAdapter<T, VB>): NutriSingleRvBinding<T, VB> {
        this.nutriAdapterCallback = nutriViewAdapterCallback
        NLog.d("$NUTRI_RV_TAG - injector-adaptCallback : $nutriAdapterCallback")
        return this
    }

    protected open fun createAdapter() {
        optionAdapter = NutriRvConstant.NUTRI_ADAPTER_R_CLASS
        nutriViewAdapter.setCallback(object : INutriBindingHolder<T, VB> {
            override fun setupInitComponent(
                binding: VB,
                data: T,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<T>
            ) {
                nutriAdapterCallback.setupInitComponent(binding, data, position, notifyListener)
            }

            override fun setViewBinding(parent: ViewGroup): VB {
                return nutriAdapterCallback.setViewBinding(parent)
            }
        })

        nutriViewAdapter.setupRequirement(listData, object : NutriRecyclerBindingListener<T, VB> {
            override fun onItemClicked(
                binding: VB,
                data: T,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<T>
            ) {
                nutriAdapterCallback.onItemClicked(binding, data, position, notifyListener)
            }

            override fun onItemLongClicked(
                binding: VB,
                data: T,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<T>
            ) {
                nutriAdapterCallback.onItemLongClicked(binding, data, position, notifyListener)
            }
        })
    }

    protected open fun setupInnerAdapter() {
        NLog.d("$NUTRI_RV_TAG - injector-optionAdapter : $optionAdapter")
        nutriRecycleView.adapter = nutriViewAdapter
    }

    override fun build(): NutriSingleRvBinding<T, VB> {
        createAdapter()
        setupLayoutManager(nutriRecycleView)
        setupInnerAdapter()
        return this
    }

}