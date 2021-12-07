package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.simple

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.model.People
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewHolder

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
 * com.frogobox.frogorecyclerviewadapter
 *
 */
class KotlinSampleViewAdapter : NutriRecyclerViewAdapter<People>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NutriRecyclerViewHolder<People> {
        return KotlinSampleViewHolder(viewLayout(parent))
    }

    inner class KotlinSampleViewHolder(view: View) : NutriRecyclerViewHolder<People>(view) {

        private val tvExampleItem = view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title)

        override fun initComponent(
            data: People,
            position: Int,
            listener: NutriRecyclerNotifyListener<People>
        ) {
            tvExampleItem.text = data.name
        }
    }

}