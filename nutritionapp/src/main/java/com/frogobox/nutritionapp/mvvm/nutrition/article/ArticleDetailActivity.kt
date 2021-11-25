package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.os.Bundle
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityArticleDetailBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.news.Article
import com.google.gson.Gson

class ArticleDetailActivity : BaseActivity<ActivityArticleDetailBinding>() {

    private val extraDataContent by lazy {
        Gson().fromJson(
            intent.getStringExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL),
            Article::class.java
        )
    }

    private val extraDataTitle by lazy {
        intent.getStringExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE)
    }

    override fun setupViewBinding(): ActivityArticleDetailBinding {
        return ActivityArticleDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        extraDataTitle?.let { setupDetailActivity(it) }
        binding.apply {
            tvTitle.text = extraDataContent.title
            tvOverview.text = extraDataContent.content
            Glide.with(this@ArticleDetailActivity).load(extraDataContent.urlToImage).into(ivPoster)
        }
    }
}