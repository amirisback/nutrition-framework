package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.os.Bundle
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutritionArticleDetailBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.news.Article
import com.google.gson.Gson

class NutritionArticleDetailActivity : BaseActivity<ActivityNutritionArticleDetailBinding>() {

    override fun setupViewBinding(): ActivityNutritionArticleDetailBinding {
        return ActivityNutritionArticleDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE_DETAIL)

        val extraData = Gson().fromJson(
            intent.getStringExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL),
            Article::class.java
        )

        binding.apply {
            tvTitle.text = extraData.title
            tvOverview.text = extraData.content
            Glide.with(this@NutritionArticleDetailActivity).load(extraData.urlToImage).into(ivPoster)
        }
    }
}