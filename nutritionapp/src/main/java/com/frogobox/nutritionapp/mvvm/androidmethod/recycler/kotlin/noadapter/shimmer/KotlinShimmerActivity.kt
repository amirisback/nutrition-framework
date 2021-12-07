package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.shimmer

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityKotlinShimmerBinding
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class KotlinShimmerActivity : BaseActivity<ActivityKotlinShimmerBinding>() {

    private val articleViewModel: ArticleViewModel by viewModel()


    override fun setupViewBinding(): ActivityKotlinShimmerBinding {
        return ActivityKotlinShimmerBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {

            getEverythings("Android")
            topHeadlineLive.observe(this@KotlinShimmerActivity, {
                it.articles?.let { it1 -> setupFrogoShimmerRecyclerView(it1) }
            })

            eventShowProgress.observe(this@KotlinShimmerActivity, {
                if (it) {
                    binding.rvShimmer.startShimmer()
                } else {
                    binding.rvShimmer.stopShimmer()
                }
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Kotlin FrogoShimmerRecyclerView Sample")
        setupShimmerLoading()
        setupButtonShimmer()
    }

    private fun setupFrogoShimmerRecyclerView(data: List<Article>) {

        val adapterCallback = object :
            INutriViewAdapter<Article> {
            override fun setupInitComponent(
                view: View,
                data: Article,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Article>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.title
            }

            override fun onItemClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Article>
            ) {
                // setup item clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Article>
            ) {
                // setup item long clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }
        }

        binding.rvShimmer.defineRecyclerView<Article>()
            .addData(data)
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupShimmer(state: Boolean) {
        if (state) {
            binding.rvShimmer.startShimmer()
        } else {
            binding.rvShimmer.stopShimmer()
        }
    }

    private fun setupButtonShimmer() {
        var bool = false
        binding.buttonShimmer.setOnClickListener {
            bool = !bool
            setupShimmer(bool)
        }
    }

    private fun setupShimmerLoading() {
        binding.rvShimmer.defineShimmerView()
            .addShimmerSumOfItemLoading(7)
            .addShimmerViewPlaceHolder(R.layout.nutri_rv_list_type_1)
            .createLayoutLinearVertical(false)
            .build()
    }

}