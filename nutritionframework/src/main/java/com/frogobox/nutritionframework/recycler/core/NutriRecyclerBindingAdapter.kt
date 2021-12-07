package com.frogobox.nutritionframework.recycler.core

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant.NUTRI_RV_TAG

/*
 * Created by Faisal Amir
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.base
 * 
 */
abstract class NutriRecyclerBindingAdapter<T, VB : ViewBinding> :
    RecyclerView.Adapter<NutriRecyclerBindingHolder<T, VB>>() {

    protected var viewListener: NutriRecyclerBindingListener<T, VB>? = null
    protected val listData = mutableListOf<T>()

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: NutriRecyclerBindingHolder<T, VB>, position: Int) {
        NLog.d("$NUTRI_RV_TAG - listData : ${listData.size}")
        holder.bindItem(listData[position], position, viewListener)
    }

    fun setupData(data: List<T>?) {
        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

    fun setupListener(listener: NutriRecyclerBindingListener<T, VB>?) {
        if (listener != null) {
            viewListener = listener
        }
    }

    fun setupRequirement(
        data: List<T>?,
        listener: NutriRecyclerBindingListener<T, VB>?
    ) {

        if (listener != null) {
            viewListener = listener
        }

        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

}