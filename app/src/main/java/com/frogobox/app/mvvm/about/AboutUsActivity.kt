package com.frogobox.app.mvvm.about

import android.os.Bundle
import com.frogobox.app.core.BaseActivity
import com.frogobox.app.databinding.ActivityAboutUsBinding

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
