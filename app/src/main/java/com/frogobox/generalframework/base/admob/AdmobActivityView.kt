package com.frogobox.generalframework.base.admob

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

interface AdmobActivityView {

    fun setupShowAdsInterstitial()

    fun setupShowAdsBanner(mAdView: AdView)

}