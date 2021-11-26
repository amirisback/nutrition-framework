package com.frogobox.nutritionframework.recycler.core

import android.view.View
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView

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
class NutriBuilderRv<T> : NutriBuilderRvBase<T>() {

    fun initBuilder(nutriRecyclerView: NutriRecyclerView): NutriBuilderRv<T> {
        init(nutriRecyclerView)
        return this
    }

    fun builder(listener: INutriBuilderRv<T>) {

        optionAdapter = NutriRvConstant.NUTRI_ADAPTER_R_CLASS

        listData.addAll(listener.setupData())

        val nutriViewAdapter = NutriViewAdapter<T>()

        nutriViewAdapter.setCallback(object : INutriViewHolder<T> {
            override fun setupInitComponent(view: View, data: T) {
                listener.setupInitComponent(view, data)
            }
        })

        nutriViewAdapter.setupRequirement(
            listener.setupCustomView(), listData,
            object : NutriRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    listener.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    listener.onItemLongClicked(data)
                }
            })

        if (listener.setupEmptyView() != null) {
            nutriViewAdapter.setupEmptyView(listener.setupEmptyView())
        } else {
            nutriViewAdapter.setupEmptyView(emptyViewId)
        }

        nutriRecyclerView.adapter = nutriViewAdapter
        nutriRecyclerView.layoutManager = listener.setupLayoutManager(nutriRecyclerView.context)

    }

}