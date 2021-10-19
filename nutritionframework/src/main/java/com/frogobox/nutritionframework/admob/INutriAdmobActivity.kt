package com.frogobox.nutritionframework.admob

import com.frogobox.nutritionframework.admob.INutriAdmob
import com.google.android.gms.ads.AdView

/*
 * Created by faisalamir on 01/07/21
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriAdmobActivity {

    // Setup Admob Publisher
    fun setupAdsPublisher(mPublisherId: String)

    // Setup Admob Banner
    fun setupAdsBanner(mAdUnitId: String)

    // Setup Admob Interstitial
    fun setupAdsInterstitial(mAdUnitId: String)

    // Setup Admob Rewarded
    fun setupAdsRewarded(mAdUnitId: String)

    // Setup Admob RewardedInterstitial
    fun setupAdsRewardedInterstitial(mAdUnitId: String)

    // Show Banner Ads
    fun setupShowAdsBanner(mAdView: AdView)

    // Show Interstitial Ads
    fun setupShowAdsInterstitial()

    // Show Rewarded Ads
    fun setupShowAdsRewarded(callback: INutriAdmob.UserEarned)

    // Show Rewarded Interstitial Ads
    fun setupShowAdsRewardedInterstitial(callback: INutriAdmob.UserEarned)

}