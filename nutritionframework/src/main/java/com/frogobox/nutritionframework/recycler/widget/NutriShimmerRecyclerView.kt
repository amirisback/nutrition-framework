package com.frogobox.nutritionframework.recycler.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.frogobox.nutritionframework.R
import com.frogobox.nutritionframework.databinding.WidgetNutriShimmerRecyclerviewBinding
import com.frogobox.nutritionframework.recycler.core.NutriSingleRv
import com.frogobox.nutritionframework.recycler.core.NutriSingleSrv
import com.frogobox.nutritionframework.recycler.widget.NutriStyleComponent.setupComponentFrogoRecyclerView

/*
 * Created by Faisal Amir on 02/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class NutriShimmerRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyle, defStyleRes), INutriShimmerRecyclerView {

    private lateinit var binding: WidgetNutriShimmerRecyclerviewBinding

    init {
        setupViewEditor()
        setupAttribute(attrs)
    }

    private fun setupViewEditor() {
        binding =
            WidgetNutriShimmerRecyclerviewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun setupAttribute(attrs: AttributeSet?) {
        attrs?.let {
            val styleArrayRecyclerView =
                context?.obtainStyledAttributes(it, R.styleable.nutri_recycler_view, 0, 0)

            // setup inner component
            binding.apply {
                styleArrayRecyclerView?.let { it1 ->
                    setupComponentFrogoRecyclerView(
                        it1,
                        widgetFsrvRecyclerview
                    )
                }
                styleArrayRecyclerView?.let { it1 ->
                    setupComponentFrogoRecyclerView(
                        it1,
                        widgetFsrvShimmerRecyclerview
                    )
                }
            }

            styleArrayRecyclerView?.recycle()
        }
    }

    override fun startShimmer() {
        binding.apply {
            widgetFsrvShimmer.visibility = View.VISIBLE
            widgetFsrvShimmer.startShimmer()
        }
    }

    override fun stopShimmer() {
        binding.apply {
            widgetFsrvShimmer.visibility = View.GONE
            widgetFsrvShimmer.stopShimmer()
        }
    }

    override fun defineShimmerView(): NutriSingleSrv {
        return NutriSingleSrv().initSingleton(binding.widgetFsrvShimmerRecyclerview) as NutriSingleSrv
    }

    override fun <T> defineRecyclerView(): NutriSingleRv<T> {
        return NutriSingleRv<T>().initSingleton(binding.widgetFsrvRecyclerview)
    }

}