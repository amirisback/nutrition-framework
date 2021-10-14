package com.frogobox.nutritionapp.mvvm.about

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityAboutUsBinding

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
