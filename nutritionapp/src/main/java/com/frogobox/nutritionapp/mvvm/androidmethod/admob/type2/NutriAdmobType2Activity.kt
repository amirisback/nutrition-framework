package com.frogobox.nutritionapp.mvvm.androidmethod.admob.type2

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityNutriAdmobType2Binding
import com.frogobox.nutritionapp.mvvm.androidmethod.admob.type1.NutriAdmobType1Adapter
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleViewModel
import com.frogobox.nutritionframework.admob.NutriAdmob
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class NutriAdmobType2Activity : BaseActivity<ActivityNutriAdmobType2Binding>() {

    private val articleViewModel: ArticleViewModel by viewModel()

    override fun setupViewBinding(): ActivityNutriAdmobType2Binding {
        return ActivityNutriAdmobType2Binding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        articleViewModel.apply {

            getEverythings("Nutrisi")
            topHeadlineLive.observe(this@NutriAdmobType2Activity, {
                it.articles?.let { it1 -> arrayFrogoAdmobData.addAll(it1) }
                NutriAdmob.RecyclerView.loadRecyclerBannerAds(
                    this@NutriAdmobType2Activity,
                    arrayFrogoAdmobData
                )
                setupRecyclerView()
            })

            eventShowProgress.observe(this@NutriAdmobType2Activity, {
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
            override fun onItemClicked(
                view: View,
                data: Any,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Any>
            ) {
            }

            override fun onItemLongClicked(
                view: View,
                data: Any,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Any>
            ) {
            }
        })
        return adapter
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@NutriAdmobType2Activity, 2)
            adapter = setupAdapter()
        }
    }

}