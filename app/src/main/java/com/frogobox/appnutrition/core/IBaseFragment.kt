package com.frogobox.appnutrition.core

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdView

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

interface IBaseFragment {

    fun setupShowAdsInterstitial()

    fun setupShowAdsBanner(mAdView: AdView)

    fun setupChildFragment(frameId: Int, fragment: Fragment)

    fun checkArgument(argsKey: String): Boolean

    fun setupEventEmptyView(view: View, isEmpty: Boolean)

    fun setupEventProgressView(view: View, progress: Boolean)

    fun showToast(message: String)

    fun <Model> baseNewInstance(argsKey: String, data: Model)

}