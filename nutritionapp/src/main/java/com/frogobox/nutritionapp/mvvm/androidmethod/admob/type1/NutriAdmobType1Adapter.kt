package com.frogobox.nutritionapp.mvvm.androidmethod.admob.type1

import android.view.ViewGroup
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionframework.admob.AdmobViewHolder
import com.frogobox.nutritionframework.admob.INutriAdmobViewAdapter
import com.frogobox.nutritionframework.admob.NutriAdmobViewAdapter
import com.frogobox.nutritionframework.admob.NutriAdmobViewHolder


/*
 * Created by faisalamir on 26/11/21
 * NutritionFramework
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

class NutriAdmobType1Adapter : NutriAdmobViewAdapter<Any>() {

    init {
        viewCallback = object : INutriAdmobViewAdapter<Any> {
            override fun onViewTypeMenuItem(parent: ViewGroup): NutriAdmobViewHolder<Any> {
                return NutriAdmobType1Holder(viewLayout(parent))
            }
            override fun onViewTypeBannerAds(parent: ViewGroup): NutriAdmobViewHolder<Any> {
                return AdmobViewHolder(viewLayout(parent, R.layout.item_ad_banner))
            }
        }
    }

}