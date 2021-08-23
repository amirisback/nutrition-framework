package com.frogobox.appnutrition.core

import android.view.View
import androidx.fragment.app.Fragment

/*
 * Created by Faisal Amir on 13/05/2020
 * BaseMusicPlayer Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface IBaseActivity {

    fun setupDetailActivity(title: String)

    fun setupChildFragment(frameId: Int, fragment: Fragment)

    fun showToast(message: String)

    fun setupEventEmptyView(view: View, isEmpty: Boolean)

    fun setupEventProgressView(view: View, progress: Boolean)

    fun checkExtra(extraKey: String): Boolean

    fun <Model> baseFragmentNewInstance(fragment: BaseFragment<*>, argumentKey: String, extraDataResult: Model)

}
