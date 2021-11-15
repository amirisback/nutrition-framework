package com.frogobox.nutritionapp.mvvm.nutrition.category.vitamins

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityVitaminInformationBinding
import com.frogobox.nutritionapp.util.Constant

class VitaminInformationActivity : BaseActivity<ActivityVitaminInformationBinding>() {

    override fun setupViewBinding(): ActivityVitaminInformationBinding {
        return ActivityVitaminInformationBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_VITAMIN_INFORMATION)
    }

}