package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutritionArticleDetailBinding
import com.frogobox.nutritionapp.util.Constant

class NutritionArticleDetailActivity : BaseActivity<ActivityNutritionArticleDetailBinding>() {

    override fun setupViewBinding(): ActivityNutritionArticleDetailBinding {
        return ActivityNutritionArticleDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE_DETAIL)
        binding.apply {

        }
    }
}