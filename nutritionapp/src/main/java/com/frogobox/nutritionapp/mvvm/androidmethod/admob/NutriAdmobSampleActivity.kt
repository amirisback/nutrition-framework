package com.frogobox.nutritionapp.mvvm.androidmethod.admob

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityNutriAdmobSampleBinding
import com.frogobox.nutritionapp.mvvm.androidmethod.admob.type1.NutriAdmobType1Activity
import com.frogobox.nutritionapp.mvvm.androidmethod.admob.type2.NutriAdmobType2Activity
import com.frogobox.nutritionapp.util.Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_ADMOB
import com.frogobox.nutritionframework.admob.INutriAdmob
import com.google.android.gms.ads.rewarded.RewardItem

class NutriAdmobSampleActivity : BaseActivity<ActivityNutriAdmobSampleBinding>() {

    override fun setupViewBinding(): ActivityNutriAdmobSampleBinding {
        return ActivityNutriAdmobSampleBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(ACTIVITY_ANDROID_METHOD_ADMOB)
        setupButtonClick()
        setupShowAdsBanner(binding.includeAdsView.adsPhoneTabSpecialSmartBanner)
    }

    private fun setupButtonClick() {

        binding.apply {

            btnInterstitial.setOnClickListener {
                setupShowAdsInterstitial()
            }

            btnRewarded.setOnClickListener {
                setupShowAdsRewarded(object : INutriAdmob.UserEarned {
                    override fun onUserEarnedReward(rewardItem: RewardItem) {
                        // TODO User Get Reward
                    }
                })
            }

            btnRewardedInterstitial.setOnClickListener {
                setupShowAdsRewardedInterstitial(object : INutriAdmob.UserEarned {
                    override fun onUserEarnedReward(rewardItem: RewardItem) {
                        // TODO User Get Reward
                    }
                })
            }

            btnRecyclerView.setOnClickListener {
                baseStartActivity<NutriAdmobType1Activity>()
            }

            btnRecyclerView2.setOnClickListener {
                baseStartActivity<NutriAdmobType2Activity>()
            }

            btnComposeActivity.setOnClickListener {
                baseStartActivity<NutriAdmobComposeActivity>()
            }

            btnHybridActivity.setOnClickListener {
                baseStartActivity<NutriAdmobHybridActivity>()
            }

        }
    }

}
