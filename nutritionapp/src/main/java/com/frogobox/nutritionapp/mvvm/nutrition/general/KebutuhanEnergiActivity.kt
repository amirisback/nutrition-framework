package com.frogobox.nutritionapp.mvvm.nutrition.general

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityKebutuhanEnergiBinding
import com.frogobox.nutritionapp.util.Constant

class KebutuhanEnergiActivity : BaseActivity<ActivityKebutuhanEnergiBinding>() {

    override fun setupViewBinding(): ActivityKebutuhanEnergiBinding {
        return ActivityKebutuhanEnergiBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI)
        binding.apply {

        }

    }
}