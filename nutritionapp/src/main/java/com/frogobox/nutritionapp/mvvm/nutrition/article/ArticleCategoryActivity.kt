package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityArticleCategoryBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleCategoryActivity : BaseActivity<ActivityArticleCategoryBinding>() {

    private val articleViewModel: ArticleViewModel by viewModel()

    private val extraDataQuery by lazy {
        intent.extras?.getString(Constant.Extra.EXTRA_ARTICLE)
    }

    private val extraDataTitle by lazy {
        intent.extras?.getString(Constant.Extra.EXTRA_ARTICLE_TITLE)
    }

    override fun setupViewBinding(): ActivityArticleCategoryBinding {
        return ActivityArticleCategoryBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {

            extraDataQuery?.let { getEverythings(it) }
            topHeadlineLive.observe(this@ArticleCategoryActivity, {
                it.articles?.let { it1 -> setupRvNews(it1) }
            })

            eventShowProgress.observe(this@ArticleCategoryActivity, {
                setupEventProgressView(binding.progressView, it)
            })

        }

    }

    override fun setupUI(savedInstanceState: Bundle?) {
        extraDataTitle?.let { setupDetailActivity(it) }
        binding.apply {

        }
    }


    private fun setupRvNews(data: List<Article>) {

        val newsAdapter = object : INutriViewAdapter<Article> {
            override fun onItemClicked(data: Article) {
                val extraData = Gson().toJson(data)
                val intent = Intent(this@ArticleCategoryActivity, ArticleDetailActivity::class.java)
                    .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL, extraData)
                    .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE, extraDataTitle)
                startActivity(intent)
            }

            override fun onItemLongClicked(data: Article) {

            }

            override fun setupInitComponent(view: View, data: Article) {
                view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_title).text = data.title
                view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_desc).text =
                    data.description
                view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_subtitle).text =
                    data.source?.name ?: "Unknowm"
                Glide.with(view.context).load(data.urlToImage)
                    .into(view.findViewById(R.id.nutri_rv_list_type_11_iv_poster))
            }
        }

        binding.rvNews
            .injector<Article>()
            .addData(data)
            .addCustomView(R.layout.nutri_rv_list_type_11)
            .addEmptyView(null)
            .addCallback(newsAdapter)
            .createLayoutLinearVertical(false)
            .build()
    }

}