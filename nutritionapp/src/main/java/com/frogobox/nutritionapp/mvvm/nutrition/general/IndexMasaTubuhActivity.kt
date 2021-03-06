package com.frogobox.nutritionapp.mvvm.nutrition.general

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityIndexMasaTubuhBinding
import com.frogobox.nutritionapp.util.Constant

class IndexMasaTubuhActivity : BaseActivity<ActivityIndexMasaTubuhBinding>() {

    override fun setupViewBinding(): ActivityIndexMasaTubuhBinding {
        return ActivityIndexMasaTubuhBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH)
    }

}