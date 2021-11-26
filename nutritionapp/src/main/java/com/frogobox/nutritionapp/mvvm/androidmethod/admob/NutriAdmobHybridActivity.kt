package com.frogobox.nutritionapp.mvvm.androidmethod.admob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutriAdmobHybridBinding

class NutriAdmobHybridActivity : BaseActivity<ActivityNutriAdmobHybridBinding>() {

    override fun setupViewBinding(): ActivityNutriAdmobHybridBinding {
        return ActivityNutriAdmobHybridBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {
            composeView.setContent {
                Greeting("NutriAdmob")
            }
            setupShowAdsBanner(includeAdsView.adsPhoneTabSpecialSmartBanner)
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

}