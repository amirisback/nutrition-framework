package com.frogobox.appnutrition.mvvm.detail

import android.os.Bundle
import com.frogobox.appnutrition.core.BaseActivity
import com.frogobox.appnutrition.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {

        }
    }
}