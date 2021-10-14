package com.frogobox.nutritionapp.mvvm.detail

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityDetailBinding

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