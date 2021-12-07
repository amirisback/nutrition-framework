package com.frogobox.nutritionframework.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
abstract class NutriRecyclerBindingHolder<T, VB : ViewBinding>(private val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun initComponent(binding: VB, data: T, position: Int, listener: NutriRecyclerNotifyListener<T>) // component view

    fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindItem(data: T?, position: Int, listener: NutriRecyclerBindingListener<T, VB>?, notifylistener: NutriRecyclerNotifyListener<T>) {
        if (data != null) {
            onItemViewClicked(data, position, listener, notifylistener)
            initComponent(binding, data, position, notifylistener)
        }
    }

    private fun onItemViewClicked(
        data: T?,
        position: Int,
        listener: NutriRecyclerBindingListener<T, VB>?,
        notifylistener: NutriRecyclerNotifyListener<T>
    ) {
        binding.root.setOnClickListener {
            if (data != null) {
                listener?.onItemClicked(binding, data, position, notifylistener)
            }
        }
        binding.root.setOnLongClickListener {
            if (data != null) {
                listener?.onItemLongClicked(binding, data, position, notifylistener)
            }
            true
        }
    }

}