package com.frogobox.appnutrition.mvvm.about

import android.os.Bundle
import com.frogobox.appnutrition.core.BaseActivity
import com.frogobox.appnutrition.databinding.ActivityAboutUsBinding

class AboutUsActivity : BaseActivity<ActivityAboutUsBinding>() {

    override fun setupViewBinding(): ActivityAboutUsBinding {
        return ActivityAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("")
        binding.apply {

        }
    }
}
