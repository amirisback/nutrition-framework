package com.frogobox.nutritionframework.admob

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.nutritionframework.admob.NutriAdmob.Banner.setupBanner
import com.frogobox.nutritionframework.admob.NutriAdmob.Banner.showBanner
import com.frogobox.nutritionframework.admob.NutriAdmob.Interstitial.setupInterstitial
import com.frogobox.nutritionframework.admob.NutriAdmob.Interstitial.showInterstitial
import com.frogobox.nutritionframework.admob.NutriAdmob.Publisher.setupPublisher
import com.frogobox.nutritionframework.admob.NutriAdmob.Rewarded.setupRewarded
import com.frogobox.nutritionframework.admob.NutriAdmob.Rewarded.showRewarded
import com.frogobox.nutritionframework.admob.NutriAdmob.RewardedInterstitial.setupRewardedInterstitial
import com.frogobox.nutritionframework.admob.NutriAdmob.RewardedInterstitial.showRewardedInterstitial
import com.frogobox.nutritionframework.admob.NutriAdmob.setupBannerAdUnitID
import com.frogobox.nutritionframework.admob.NutriAdmob.setupInterstialAdUnitID
import com.frogobox.nutritionframework.admob.NutriAdmob.setupPublisherID
import com.frogobox.nutritionframework.admob.NutriAdmob.setupRewardedAdUnitID
import com.frogobox.nutritionframework.admob.NutriAdmob.setupRewardedInterstitialAdUnitID
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
 * com.frogobox.admobhelper
 *
 */

abstract class NutriAdmobActivity : AppCompatActivity(), INutriAdmobActivity {

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun setupAdsPublisher(mPublisherId: String) {
        setupPublisherID(mPublisherId)
        setupPublisher(this)
    }

    override fun setupAdsBanner(mAdUnitId: String) {
        setupBannerAdUnitID(mAdUnitId)
    }

    override fun setupAdsInterstitial(mAdUnitId: String) {
        setupInterstialAdUnitID(mAdUnitId)
        setupInterstitial(this)
    }

    override fun setupAdsRewarded(mAdUnitId: String) {
        setupRewardedAdUnitID(mAdUnitId)
        setupRewarded(this)
    }

    override fun setupAdsRewardedInterstitial(mAdUnitId: String) {
        setupRewardedInterstitialAdUnitID(mAdUnitId)
        setupRewardedInterstitial(this)
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        setupBanner(mAdView)
        showBanner(mAdView)
    }

    override fun setupShowAdsInterstitial() {
        showInterstitial(this)
    }

    override fun setupShowAdsRewarded(callback: INutriAdmob.UserEarned) {
        showRewarded(this, callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: INutriAdmob.UserEarned) {
        showRewardedInterstitial(this, callback)
    }

    override fun onResume() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }
        super.onDestroy()
    }

}