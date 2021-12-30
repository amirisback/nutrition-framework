package com.frogobox.nutritionapp.mvvm.androidmethod.recycler

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityNutriRecyclerSampleBinding
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.noadapter.multiview.JavaNoAdapterMultiViewActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.noadapter.simple.JavaNoAdapterActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.usingadapter.JavaSampleActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.compose.RecyclerComposeActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.multiview.KotlinNoAdapterMultiVewActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.progress.KotlinProgressActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.shimmer.KotlinShimmerActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.simple.KotlinNoAdapterActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.nested.KotlinNestedActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.nested.KotlinSimpleNestedActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.simple.KotlinSampleActivity
import com.frogobox.nutritionapp.util.Constant

class NutriRecyclerSampleActivity : BaseActivity<ActivityNutriRecyclerSampleBinding>() {

    override fun setupViewBinding(): ActivityNutriRecyclerSampleBinding {
        return ActivityNutriRecyclerSampleBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_RV)
        binding.apply {
            btnWithData.setOnClickListener {
                baseStartActivity<KotlinSampleActivity>()
            }

            btnEmptyData.setOnClickListener {
                baseStartActivity<JavaSampleActivity>()
            }

            btnJavaNoAdapter.setOnClickListener {
                baseStartActivity<JavaNoAdapterActivity>()
            }

            btnKotlinNoAdapter.setOnClickListener {
                baseStartActivity<KotlinNoAdapterActivity>()
            }

            btnKotlinMultiview.setOnClickListener {
                baseStartActivity<KotlinNoAdapterMultiVewActivity>()
            }

            btnJavaMultiview.setOnClickListener {
                baseStartActivity<JavaNoAdapterMultiViewActivity>()
            }

            btnKotlinShimmer.setOnClickListener {
                baseStartActivity<KotlinShimmerActivity>()
            }

            btnKotlinProgress.setOnClickListener {
                baseStartActivity<KotlinProgressActivity>()
            }

            btnNestedSimple.setOnClickListener {
                baseStartActivity<KotlinSimpleNestedActivity>()
            }

            btnNested.setOnClickListener {
                baseStartActivity<KotlinNestedActivity>()
            }

            btnJetpackCompose.setOnClickListener {
                baseStartActivity<RecyclerComposeActivity>()
            }
        }
    }
}