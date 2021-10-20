package com.frogobox.nutritionframework.admob


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.nutritionframework.admob.NutriAdmobConstant.RECYCLER_VIEW_TYPE_BANNER_AD
import com.frogobox.nutritionframework.admob.NutriAdmobConstant.RECYCLER_VIEW_TYPE_MENU_ITEM
import com.frogobox.nutritionframework.R
import com.frogobox.nutritionframework.recycler.core.NutriHolder
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * SpeechBooster
 * Copyright (C) 10/09/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.speechbooster.base
 *
 */

abstract class NutriAdmobViewAdapter<T> : RecyclerView.Adapter<NutriAdmobViewHolder<T>>() {

    protected var viewCallback: INutriAdmobViewAdapter<T>? = null
    protected var viewListener: NutriRecyclerViewListener<T>? = null

    protected val frogoHolder = mutableListOf<NutriHolder<T>>()
    protected val listData = mutableListOf<T>()
    protected var listCount = 0

    protected var hasEmptyView = false
    protected var layoutRv: Int = 0
    protected var customLayoutRestId: Int = 0
    protected var emptyLayoutResId: Int = R.layout.nutri_container_empty_view

    override fun getItemCount(): Int {
        return if (hasEmptyView) {
            listCount = if (listData.size == 0) {
                1
            } else {
                listData.size
            }
            listCount
        } else {
            listData.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutriAdmobViewHolder<T> {
        return when (viewType) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                viewCallback!!.onViewTypeMenuItem(parent)
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                viewCallback!!.onViewTypeBannerAds(parent)
            }
            else -> {
                viewCallback!!.onViewTypeBannerAds(parent)
            }
        }

    }

    override fun onBindViewHolder(holder: NutriAdmobViewHolder<T>, position: Int) {
        when (getItemViewType(position)) {
            RECYCLER_VIEW_TYPE_MENU_ITEM -> {
                holder.bindItem(listData[position], viewListener)
            }
            RECYCLER_VIEW_TYPE_BANNER_AD -> {
                holder.bindItemAdView(listData[position])
            }
            else -> {
                holder.bindItemAdView(listData[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % NutriAdmobConstant.RECYCLER_VIEW_ITEMS_PER_AD == 0) RECYCLER_VIEW_TYPE_BANNER_AD else RECYCLER_VIEW_TYPE_MENU_ITEM
    }

    protected fun viewLayout(parent: ViewGroup, layout: Int): View {
        return LayoutInflater.from(parent.context).inflate(layout, parent, false)
    }


    private fun verifyViewInt() {
        if (listData.isNotEmpty()) {
            layoutRv = customLayoutRestId
        } else {
            layoutRv = emptyLayoutResId
        }
    }

    private fun layoutHandle() {
        if (customLayoutRestId != 0) {
            verifyViewInt()
        }
    }

    private fun emptyViewHandle() {
        layoutHandle()
    }

    fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            emptyLayoutResId = emptyView
        }
        emptyViewHandle()
    }

    fun setupRequirement(
            customViewInt: Int,
            listData: List<T>?,
            listener: NutriRecyclerViewListener<T>?
    ) {

        if (listener != null) {
            viewListener = listener
        }

        this.listData.clear()
        if (listData != null) {
            this.listData.addAll(listData)
        }

        customLayoutRestId = customViewInt
        emptyViewHandle()
    }

    fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

}