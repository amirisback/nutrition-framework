package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.databinding.ActivityArticleCategoryBinding
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
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
            override fun onItemClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Article>
            ) {
                val extraData = Gson().toJson(data)
                val intent = Intent(this@ArticleCategoryActivity, ArticleDetailActivity::class.java)
                    .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL, extraData)
                    .putExtra(Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE, extraDataTitle)
                startActivity(intent)
            }

            override fun onItemLongClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Article>
            ) {

            }

            override fun setupInitComponent(
                view: View,
                data: Article,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Article>
            ) {
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchItem: MenuItem? = menu.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { NLog.d(it) }
                query?.let { articleViewModel.getEverythings(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { NLog.d(it) }
                newText?.let { articleViewModel.getEverythings(it) }
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)
    }


}