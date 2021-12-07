package com.frogobox.nutritionframework.admob

import android.view.View
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener

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

class AdmobViewHolder(view: View) : NutriAdmobViewHolder<Any>(view) {
    override fun initComponent(
        data: Any,
        position: Int,
        listener: NutriRecyclerNotifyListener<Any>
    ) {
    }
}