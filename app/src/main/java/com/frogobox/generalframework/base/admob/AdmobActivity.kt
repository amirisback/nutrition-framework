package com.frogobox.generalframework.base.admob

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.generalframework.util.helper.AdmobHelper.Banner.setupBanner
import com.frogobox.generalframework.util.helper.AdmobHelper.Banner.showBanner
import com.frogobox.generalframework.util.helper.AdmobHelper.Interstitial.setupInterstitial
import com.frogobox.generalframework.util.helper.AdmobHelper.Interstitial.showInterstitial
import com.frogobox.generalframework.util.helper.AdmobHelper.Publisher.setupPublisher
import com.google.android.gms.ads.AdView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 31/10/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer
 *
 */

open class AdmobActivity : AppCompatActivity(),
    AdmobActivityView {

    private lateinit var mActivity: AppCompatActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        setupAdmob()
    }

    private fun setupAdmob() {
        setupPublisher(this)
        setupAdmobInterstitial()
//        setupAdmobVideo(context)
    }

    private fun setupAdmobInterstitial() {
        setupInterstitial(this)
    }

    override fun setupShowAdsInterstitial() {
        showInterstitial(this)
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        setupBanner(mAdView)
        showBanner(mAdView)
    }

}