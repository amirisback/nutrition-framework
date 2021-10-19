package com.frogobox.nutritionframework.core

import android.view.View
import androidx.fragment.app.Fragment

/*
 * Created by faisalamir on 28/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriFragment {

    fun setupChildFragment(frameId: Int, fragment: Fragment)

    fun checkArgument(argsKey: String): Boolean

    fun setupEventEmptyView(view: View, isEmpty: Boolean)

    fun setupEventProgressView(view: View, progress: Boolean)

    fun showToast(message: String)

    fun <Model> baseNewInstance(argsKey: String, data: Model)

}