package com.frogobox.nutritionapp.mvvm.nutrition.vitamin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityVitaminBinding
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleDetailActivity
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionapp.util.Constant.Const.CONS_VITAMIN_A
import com.frogobox.nutritionapp.util.Constant.Const.CONS_VITAMIN_C
import com.frogobox.nutritionapp.util.Constant.Const.CONS_VITAMIN_E
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritioncore.model.vitamin.VitaminContent
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class VitaminActivity : BaseActivity<ActivityVitaminBinding>() {

    private val articleViewModel: ArticleViewModel by viewModel()
    private val vitaminViewModel: VitaminViewModel by viewModel()

    private val extraDataQuery by lazy {
        intent.extras?.getString(Constant.Extra.EXTRA_ARTICLE)
    }

    private val extraDataTitle by lazy {
        intent.extras?.getString(Constant.Extra.EXTRA_ARTICLE_TITLE)
    }

    override fun setupViewBinding(): ActivityVitaminBinding {
        return ActivityVitaminBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {
            extraDataQuery?.let { getEverythings(it) }
            topHeadlineLive.observe(this@VitaminActivity, {
                it.articles?.let { it1 -> setupRvNews(it1) }
            })

            eventShowProgress.observe(this@VitaminActivity, {
                setupEventProgressView(binding.progressView, it)
            })
        }

        vitaminViewModel.apply {

            when (extraDataQuery) {
                CONS_VITAMIN_A -> {
                    getVitaminA()
                }
                CONS_VITAMIN_C -> {
                    getVitaminC()
                }
                CONS_VITAMIN_E -> {
                    getVitaminE()
                }
            }

            dataVitamin.observe(this@VitaminActivity, {

                binding.apply {
                    tvTitleNews.text = "Berita Terkini ${it.vitamin_name}"
                    tvTitleVitamin.text = "Informasi Detail ${it.vitamin_name}"
                }

                setupRvVitamin(it.vitamin_content)
            })

            eventShowProgress.observe(this@VitaminActivity, {
                setupEventProgressView(binding.progressView, it)
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        extraDataQuery?.let { setupDetailActivity(it) }
        binding.apply {

        }
    }

    private fun setupRvNews(data: List<Article>) {

        val newsAdapter = object : INutriViewAdapter<Article> {
            override fun onItemClicked(view: View, data: Article, position: Int) {
                val extraData = Gson().toJson(data)
                val intent = Intent(this@VitaminActivity, ArticleDetailActivity::class.java)
                    .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL, extraData)
                    .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE, extraDataTitle)
                startActivity(intent)
            }

            override fun onItemLongClicked(view: View, data: Article, position: Int) {

            }

            override fun setupInitComponent(view: View, data: Article, position: Int) {
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
            .createLayoutLinearHorizontal(false)
            .build()
    }

    private fun setupRvVitamin(data: List<VitaminContent>) {

        val vitaminAdapter = object : INutriViewAdapter<VitaminContent> {
            override fun onItemClicked(view: View, data: VitaminContent, position: Int) {
            }

            override fun onItemLongClicked(view: View, data: VitaminContent, position: Int) {
            }

            override fun setupInitComponent(view: View, data: VitaminContent, position: Int) {
                view.findViewById<TextView>(R.id.nutri_rv_list_type_2_tv_title).text =
                    data.information
                view.findViewById<TextView>(R.id.nutri_rv_list_type_2_tv_subtitle).text =
                    data.description
            }
        }

        binding.rvVitamin
            .injector<VitaminContent>()
            .addData(data)
            .addCustomView(R.layout.nutri_rv_list_type_2)
            .addEmptyView(null)
            .addCallback(vitaminAdapter)
            .createLayoutLinearVertical(false)
            .build()
    }

}