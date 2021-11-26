package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.nested

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityFrogoRvGridBinding
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.recycler.core.INutriNestedHolder
import com.frogobox.nutritionframework.recycler.core.INutriViewHolder
import com.frogobox.nutritionframework.recycler.core.NutriNestedAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class KotlinNestedActivity : BaseActivity<ActivityFrogoRvGridBinding>() {

    private val articleViewModel: ArticleViewModel by viewModel()

    override fun setupViewBinding(): ActivityFrogoRvGridBinding {
        return ActivityFrogoRvGridBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {

            getEverythings("android")
            topHeadlineLive.observe(this@KotlinNestedActivity, {
                val listData = mutableListOf<Article>()
                it.articles?.let { it1 -> listData.addAll(it1) }
                setupRecyclerView(setupDataNested(listData))
            })

            eventShowProgress.observe(this@KotlinNestedActivity, {
                setupEventProgressView(binding.progressView, it)
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Nested RecyclerView")
    }

    private fun setupDataNested(data: MutableList<Article>): MutableList<MutableList<Article>> {
        val list = mutableListOf<MutableList<Article>>()
        for (i in 0..10) {
            list.add(data)
        }
        return list
    }

    private fun setupRecyclerView(data: MutableList<MutableList<Article>>) {

        val mLinearLayoutManager = LinearLayoutManager(this)
        val mAdapter = NutriNestedAdapter<Article>()
        mAdapter.setCallback(object : INutriNestedHolder<Article> {
            override fun nestedCustomView(): Int {
                return R.layout.nutri_rv_grid_type_3
            }

            override fun nestedListener(): NutriRecyclerViewListener<Article> {
                return object : NutriRecyclerViewListener<Article> {
                    override fun onItemClicked(data: Article) {
                        showToast("Click : $data")
                    }

                    override fun onItemLongClicked(data: Article) {
                        showToast("Long Click : $data")
                    }
                }
            }

            override fun nestedCallback(): INutriViewHolder<Article> {
                return object : INutriViewHolder<Article> {
                    override fun setupInitComponent(view: View, data: Article) {
                        val iv = view.findViewById<ImageView>(R.id.nutri_rv_grid_type_3_iv_poster)
                        val tv_title =
                            view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_title)
                        val tv_sub =
                            view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_subtitle)
                        val tv_desc = view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_desc)

                        Glide.with(view.context).load(data.urlToImage).into(iv)
                        tv_title.text = data.title
                        tv_sub.text = data.author
                        tv_desc.text = data.description
                    }
                }
            }
        })
        mAdapter.setupNestedView()
        mAdapter.setupDataNested(data)
        binding.nutriRecyclerView.apply {
            layoutManager = mLinearLayoutManager
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

}