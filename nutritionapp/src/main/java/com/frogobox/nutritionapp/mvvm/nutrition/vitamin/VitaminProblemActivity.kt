package com.frogobox.nutritionapp.mvvm.nutrition.vitamin

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityVitaminProblemBinding
import com.frogobox.nutritionapp.util.Constant

class VitaminProblemActivity : BaseActivity<ActivityVitaminProblemBinding>() {

    override fun setupViewBinding(): ActivityVitaminProblemBinding {
        return ActivityVitaminProblemBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_VITAMIN_PROBLEM)
    }
}