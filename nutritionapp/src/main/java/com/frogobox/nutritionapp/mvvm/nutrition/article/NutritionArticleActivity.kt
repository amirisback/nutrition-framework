package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutritionArticleBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionapp.util.Constant.Extra.EXTRA_ARTICLE_DETAIL
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class NutritionArticleActivity : BaseActivity<ActivityNutritionArticleBinding>() {

    private val nutritionArticleViewModel: NutritionArticleViewModel by viewModel()

    override fun setupViewBinding(): ActivityNutritionArticleBinding {
        return ActivityNutritionArticleBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        nutritionArticleViewModel.apply {

            getEverythings()
            topHeadlineLive.observe(this@NutritionArticleActivity, {
                it.articles?.let { it1 -> setupRvNews(it1) }
            })

            eventShowProgress.observe(this@NutritionArticleActivity, {
                setupEventProgressView(binding.progressView, it)
            })

        }

    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE)
        binding.apply {

        }
    }


    private fun setupRvNews(data: List<Article>) {

        val newsAdapter = object : INutriViewAdapter<Article> {
            override fun onItemClicked(data: Article) {
                val intent = Intent(
                    this@NutritionArticleActivity,
                    NutritionArticleDetailActivity::class.java
                )
                val extraData = Gson().toJson(data)
                intent.putExtra(EXTRA_ARTICLE_DETAIL, extraData)
                startActivity(intent)
            }

            override fun onItemLongClicked(data: Article) {

            }

            override fun setupInitComponent(view: View, data: Article) {
                view.findViewById<TextView>(R.id.tv_title).text = data.title
                view.findViewById<TextView>(R.id.tv_description).text = data.description
                view.findViewById<TextView>(R.id.tv_published).text = data.publishedAt
                Glide.with(view.context).load(data.urlToImage).into(view.findViewById(R.id.iv_url))
            }
        }

        binding.rvNews
            .injector<Article>()
            .addData(data)
            .addCustomView(R.layout.list_news_article_vertical)
            .addEmptyView(null)
            .addCallback(newsAdapter)
            .createLayoutLinearVertical(false)
            .build()
    }

}