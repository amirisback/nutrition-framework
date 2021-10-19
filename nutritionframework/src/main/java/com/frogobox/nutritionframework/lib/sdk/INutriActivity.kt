package com.frogobox.nutritionframework.lib.sdk

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
interface INutriActivity {

    fun setupDetailActivity(title: String)

    fun setupChildFragment(frameId: Int, fragment: Fragment)

    fun showToast(message: String)

    fun setupEventEmptyView(view: View, isEmpty: Boolean)

    fun setupEventProgressView(view: View, progress: Boolean)

    fun checkExtra(extraKey: String): Boolean

    fun <Model> baseFragmentNewInstance(
        fragment: NutriFragment<*>,
        argumentKey: String,
        extraDataResult: Model
    )

    fun verifySignature()

    fun readSignature()

    fun verifyInstallerId()

    fun verifyUnauthorizedApps()

    fun verifyStores()

    fun verifyDebug()

    fun verifyEmulator()

    fun showApkSignatures()

}