package com.frogobox.nutritionframework.recycler.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.frogobox.nutritionframework.R
import com.frogobox.nutritionframework.databinding.WidgetNutriProgressRecyclerviewBinding
import com.frogobox.nutritionframework.recycler.core.NutriSingleRv
import com.frogobox.nutritionframework.recycler.widget.NutriStyleComponent.setupComponentNutriRecyclerView
import com.frogobox.nutritionframework.recycler.widget.NutriStyleComponent.setupComponentProgressBar

/*
 * Created by Faisal Amir on 17/02/2021
 * NutriRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class NutriProgressRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyle, defStyleRes), INutriProgressRecyclerView {

    private lateinit var binding: WidgetNutriProgressRecyclerviewBinding

    init {
        setupViewEditor()
        setupAttribute(attrs)
    }

    private fun setupViewEditor() {
        binding =
            WidgetNutriProgressRecyclerviewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun setupAttribute(attrs: AttributeSet?) {
        attrs?.let {
            val styleArrayRecyclerView =
                context?.obtainStyledAttributes(it, R.styleable.nutri_recycler_view, 0, 0)
            val styleArrayProgressBar =
                context?.obtainStyledAttributes(it, R.styleable.nutri_progress_bar, 0, 0)

            // setup inner component
            binding.apply {
                styleArrayRecyclerView?.let { it1 ->
                    setupComponentNutriRecyclerView(
                        it1,
                        widgetFprvRecyclerview
                    )
                }
                styleArrayProgressBar?.let { it1 ->
                    setupComponentProgressBar(
                        it1,
                        widgetFprvProgressbar
                    )
                }
            }

            styleArrayRecyclerView?.recycle()
        }
    }

    override fun <T> defineRecyclerView(): NutriSingleRv<T> {
        return NutriSingleRv<T>().initSingleton(binding.widgetFprvRecyclerview)
    }

    override fun showProgress() {
        binding.widgetFprvProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.widgetFprvProgressbar.visibility = View.GONE
    }
}