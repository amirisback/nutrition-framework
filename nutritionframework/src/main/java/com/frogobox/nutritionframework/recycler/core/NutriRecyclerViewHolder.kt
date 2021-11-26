package com.frogobox.nutritionframework.recycler.core

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
abstract class NutriRecyclerViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun initComponent(data: T) // component view

    fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindItem(data: T?, listener: NutriRecyclerViewListener<T>?) {
        if (data != null) {
            onItemViewClicked(data, listener)
            initComponent(data)
        }
    }

    private fun onItemViewClicked(data: T?, listener: NutriRecyclerViewListener<T>?) {
        itemView.setOnClickListener {
            if (data != null) {
                listener?.onItemClicked(data)
            }
        }
        itemView.setOnLongClickListener {
            if (data != null) {
                listener?.onItemLongClicked(data)
            }
            true
        }
    }

}