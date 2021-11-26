package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.progress

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityKotlinProgressBinding
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class KotlinProgressActivity : BaseActivity<ActivityKotlinProgressBinding>() {

    private val articleViewModel: ArticleViewModel by viewModel()

    override fun setupViewBinding(): ActivityKotlinProgressBinding {
        return ActivityKotlinProgressBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {

            getEverythings("Android")
            topHeadlineLive.observe(this@KotlinProgressActivity, {
                it.articles?.let { it1 -> setupFrogoProgressRecyclerView(it1) }
            })

            eventShowProgress.observe(this@KotlinProgressActivity, {
                if (it) {
                    binding.rvProgress.showProgress()
                } else {
                    binding.rvProgress.hideProgress()
                }
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Kotlin FrogoProgressRecyclerView Sample")
        setupButtonProgress()
    }
    
    private fun setupFrogoProgressRecyclerView(data: List<Article>) {

        val adapterCallback = object :
            INutriViewAdapter<Article> {
            override fun setupInitComponent(view: View, data: Article) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.title
            }

            override fun onItemClicked(data: Article) {
                // setup item clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(data: Article) {
                // setup item long clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }
        }

        binding.rvProgress.defineRecyclerView<Article>()
            .addData(data)
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupProgress(state: Boolean) {
        binding.apply {
            if (state) {
                rvProgress.showProgress()
            } else {
                rvProgress.hideProgress()
            }
        }
    }

    private fun setupButtonProgress() {
        var bool = false
        binding.buttonProgress.setOnClickListener {
            bool = !bool
            setupProgress(bool)
        }
    }

}