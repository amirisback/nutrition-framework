package com.frogobox.generalframework.util.helper

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.generalframework.R
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


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
object AdmobHelper {

    private var mInterstitialAd: InterstitialAd? = null

    const val TAG = "Admob Helper"

    object Publisher {

        fun setupPublisher(context: Context) {
            MobileAds.initialize(context) {
                Log.d(TAG, "Mobile ads has been initialize")
            }
        }

    }

    object Interstitial {

        fun setupInterstitial(context: Context) {

            val adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                context, context.getString(R.string.admob_interstitial), adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.d(TAG, adError.message)
                        mInterstitialAd = null
                        val error = "domain: ${adError.domain}, code: ${adError.code}, " +
                                "message: ${adError.message}"
                        Log.d(TAG, "onAdFailedToLoad() with error $error")
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        Log.d(TAG, "Ad was loaded.")
                        mInterstitialAd = interstitialAd
                    }
                }
            )

        }

        fun showInterstitial(activity: AppCompatActivity) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        Log.d(TAG, "Ad was dismissed.")
                        // Don't forget to set the ad reference to null so you
                        // don't show the ad a second time.
                        mInterstitialAd = null
                        setupInterstitial(activity)
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                        Log.d(TAG, "Ad failed to show.")
                        // Don't forget to set the ad reference to null so you
                        // don't show the ad a second time.
                        mInterstitialAd = null
                    }

                    override fun onAdShowedFullScreenContent() {
                        Log.d(TAG, "Ad showed fullscreen content.")
                        // Called when ad is dismissed.
                    }
                }
                mInterstitialAd?.show(activity)
            }

        }

    }

    object Banner {

        fun setupBanner(mAdView: AdView) {
            mAdView.adListener = object : AdListener() {
                override fun onAdLoaded() {}
                override fun onAdFailedToLoad(p0: LoadAdError) {}
                override fun onAdOpened() {}
                override fun onAdClicked() {}
                override fun onAdClosed() {}
            }
        }

        fun showBanner(mAdView: AdView) {
            mAdView.loadAd(AdRequest.Builder().build())
        }

    }


}