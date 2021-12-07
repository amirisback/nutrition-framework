package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.simple

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityFrogoRvListBinding
import com.frogobox.nutritionapp.model.People
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener

class KotlinSampleActivity : BaseActivity<ActivityFrogoRvListBinding>() {

    private val dummyData = Constant.dummyData("Framework Nutrition")

    override fun setupViewBinding(): ActivityFrogoRvListBinding {
        return ActivityFrogoRvListBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupAdapter()
        setupDetailActivity("Kotlin With Adapter")
    }

    private fun setupAdapter() {
        val adapter = KotlinSampleViewAdapter()
        adapter.setupRequirement(
            R.layout.nutri_rv_list_type_1,
            dummyData,
            object : NutriRecyclerViewListener<People> {
                override fun onItemClicked(view: View, data: People, position: Int) {
                    Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClicked(view: View, data: People, position: Int) {
                    Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                }
            }
        )
        adapter.setupEmptyView(R.layout.nutri_container_empty_view) // With Custom View
        binding.nutriRecyclerView.adapter = adapter
        binding.nutriRecyclerView.isViewLinearVertical(false)
    }

}