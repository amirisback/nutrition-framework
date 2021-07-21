package com.frogobox.app.mvvm.detail

import android.os.Bundle
import com.frogobox.app.core.BaseActivity
import com.frogobox.app.databinding.ActivityDetailBinding

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