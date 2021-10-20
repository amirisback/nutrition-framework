package com.frogobox.nutritionframework.recycler.widget

import android.content.res.TypedArray
import android.view.View
import android.widget.ProgressBar
import com.frogobox.nutritionframework.R

/*
 * Created by faisalamir on 09/05/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
object NutriStyleComponent : INutriStyleComponent {

    override fun setupComponentFrogoRecyclerView(
        typedArray: TypedArray,
        nutriRecyclerView: NutriRecyclerView
    ) {
        val attributePaddingTop =
            typedArray.getDimension(R.styleable.nutri_recycler_view_frvPaddingTop, 0F)
        val attributePaddingRight =
            typedArray.getDimension(R.styleable.nutri_recycler_view_frvPaddingRight, 0F)
        val attributePaddingBottom =
            typedArray.getDimension(R.styleable.nutri_recycler_view_frvPaddingBottom, 0F)
        val attributePaddingLeft =
            typedArray.getDimension(R.styleable.nutri_recycler_view_frvPaddingLeft, 0F)
        val attributeClipToPadding =
            typedArray.getBoolean(R.styleable.nutri_recycler_view_frvClipToPadding, true)

        nutriRecyclerView.apply {
            clipToPadding = attributeClipToPadding
            setPadding(
                attributePaddingLeft.toInt(),
                attributePaddingTop.toInt(),
                attributePaddingRight.toInt(),
                attributePaddingBottom.toInt()
            )
        }

    }

    override fun setupComponentProgressBar(typedArray: TypedArray, progressBar: ProgressBar) {
        val attributeHeight =
            typedArray.getDimension(R.styleable.nutri_progress_bar_frvProgressHeight, 0F)
        val attributeWidth =
            typedArray.getDimension(R.styleable.nutri_progress_bar_frvProgressWidth, 0F)
        val attributeVisibility = typedArray.getInteger(
            R.styleable.nutri_progress_bar_frvProgressVisibility,
            View.VISIBLE
        )

        progressBar.apply {
            visibility = attributeVisibility
        }
    }

}