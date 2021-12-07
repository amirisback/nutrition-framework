package com.frogobox.nutritionapp.mvvm.androidmethod.admob.type1

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutriAdmobType1Binding
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritionframework.admob.NutriAdmob.RecyclerView.loadRecyclerBannerAds
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class NutriAdmobType1Activity : BaseActivity<ActivityNutriAdmobType1Binding>() {

    private val articleViewModel: ArticleViewModel by viewModel()

    override fun setupViewBinding(): ActivityNutriAdmobType1Binding {
        return ActivityNutriAdmobType1Binding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {

            getEverythings("Nutrisi")
            topHeadlineLive.observe(this@NutriAdmobType1Activity, {
                it.articles?.let { it1 -> arrayFrogoAdmobData.addAll(it1) }
                loadRecyclerBannerAds(this@NutriAdmobType1Activity, arrayFrogoAdmobData)
                setupRecyclerView()
            })

            eventShowProgress.observe(this@NutriAdmobType1Activity, {
                setupEventProgressView(binding.progressView, it)
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("RecyclerView With Banner (1)")
    }

    private fun setupAdapter(): NutriAdmobType1Adapter {
        val adapter = NutriAdmobType1Adapter()
        adapter.setupRequirement(R.layout.nutri_rv_list_type_11, arrayFrogoAdmobData, object :
            NutriRecyclerViewListener<Any> {
            override fun onItemClicked(view: View, data: Any, position: Int) {}
            override fun onItemLongClicked(view: View, data: Any, position: Int) {}
        })
        return adapter
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@NutriAdmobType1Activity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = setupAdapter()
        }
    }

}