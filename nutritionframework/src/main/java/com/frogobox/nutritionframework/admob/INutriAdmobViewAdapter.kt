package com.frogobox.nutritionframework.admob

import android.view.ViewGroup

/*
 * Created by Faisal Amir on 31/01/2021
 * AdmobSamples Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriAdmobViewAdapter<T> {

    fun onViewTypeMenuItem(parent: ViewGroup) : NutriAdmobViewHolder<T>

    fun onViewTypeBannerAds(parent: ViewGroup) : NutriAdmobViewHolder<T>

}