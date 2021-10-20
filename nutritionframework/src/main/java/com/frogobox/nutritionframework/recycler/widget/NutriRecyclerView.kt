package com.frogobox.nutritionframework.recycler.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.*
import androidx.viewbinding.ViewBinding
import com.frogobox.nutritionframework.recycler.core.*


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * frogo-recycler-view-adapter
 * Copyright (C) 30/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter.view
 *
 */
class NutriRecyclerView : RecyclerView,
    INutriRecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @Deprecated(NutriRvConstant.Deprecated.isViewLinearVertical)
    override fun isViewLinearVertical(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    @Deprecated(NutriRvConstant.Deprecated.isViewLinearHorizontal)
    override fun isViewLinearHorizontal(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        }
    }

    @Deprecated(NutriRvConstant.Deprecated.isViewStaggeredGrid)
    override fun isViewStaggeredGrid(spanCount: Int) {
        layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
    }

    @Deprecated(NutriRvConstant.Deprecated.isViewGrid)
    override fun isViewGrid(spanCount: Int) {
        layoutManager = GridLayoutManager(context, spanCount)
    }

    override fun <T> injector(): NutriSingleRv<T> =
        NutriSingleRv<T>().initSingleton(this)

    override fun <T, VB : ViewBinding> injectorBinding(): NutriSingleRvBinding<T, VB> {
        return NutriSingleRvBinding<T, VB>().initSingleton(this)
    }

    override fun <T> builder(listener: INutriBuilderRv<T>) {
        return NutriBuilderRv<T>().initBuilder(this).builder(listener)
    }

    override fun <T, VB : ViewBinding> builderBinding(listener: INutriBuilderRvBinding<T, VB>) {
        return NutriBuilderRvBinding<T, VB>().initBuilder(this).builder(listener)
    }


}