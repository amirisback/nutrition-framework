package com.frogobox.nutritionapp.mvvm.nutrition.general

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityBeratBadanIdealBinding
import com.frogobox.nutritionapp.util.Constant

class BeratBadanIdealActivity : BaseActivity<ActivityBeratBadanIdealBinding>() {

    override fun setupViewBinding(): ActivityBeratBadanIdealBinding {
        return ActivityBeratBadanIdealBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {}

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL)
        binding.apply {

        }
    }
}