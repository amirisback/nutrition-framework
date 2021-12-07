package com.frogobox.nutritionframework.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
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
class NutriBuilderRvBinding<T, VB : ViewBinding> : NutriBuilderRvBase<T>() {

    fun initBuilder(nutriRecyclerView: NutriRecyclerView): NutriBuilderRvBinding<T, VB> {
        init(nutriRecyclerView)
        return this
    }

    fun builder(listener: INutriBuilderRvBinding<T, VB>) {

        optionAdapter = NutriRvConstant.NUTRI_ADAPTER_VIEW_BINDING

        listData.addAll(listener.setupData())

        val frogoBindingAdapter = NutriBindingAdapter<T, VB>()

        frogoBindingAdapter.setCallback(object : INutriBindingHolder<T, VB> {
            override fun setViewBinding(parent: ViewGroup): VB {
                return listener.setViewBinding(parent)
            }

            override fun setupInitComponent(
                binding: VB,
                data: T,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<T>
            ) {
                return listener.setupInitComponent(binding, data, position, notifyListener)
            }
        })

        frogoBindingAdapter.setupRequirement(
            listData,
            object : NutriRecyclerBindingListener<T, VB> {
                override fun onItemClicked(
                    binding: VB,
                    data: T,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<T>
                ) {
                    listener.onItemClicked(binding, data, position, notifyListener)
                }

                override fun onItemLongClicked(
                    binding: VB,
                    data: T,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<T>
                ) {
                    listener.onItemLongClicked(binding, data, position, notifyListener)
                }
            })

        nutriRecyclerView.adapter = frogoBindingAdapter
        nutriRecyclerView.layoutManager = listener.setupLayoutManager(nutriRecyclerView.context)

    }

}