package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.nested

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityFrogoRvGridBinding
import com.frogobox.nutritionframework.recycler.core.*

class KotlinSimpleNestedActivity : BaseActivity<ActivityFrogoRvGridBinding>() {

    override fun setupViewBinding(): ActivityFrogoRvGridBinding {
        return ActivityFrogoRvGridBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupData(): MutableList<Int> {
        val subList1 = mutableListOf<Int>()
        for (i in 0..10) {
            subList1.add(i)
        }
        return subList1
    }

    private fun setupDataNested(): MutableList<MutableList<Int>> {
        val list = mutableListOf<MutableList<Int>>()
        for (i in 0..5) {
            list.add(setupData())
        }
        return list
    }

    private fun setupRecyclerView() {

        val mLinearLayoutManager = LinearLayoutManager(this)
        val mAdapter = NutriNestedAdapter<Int>()
        mAdapter.setCallback(object : INutriNestedHolder<Int> {
            override fun nestedCustomView(): Int {
                return R.layout.nutri_list_nested_item
            }

            override fun nestedListener(): NutriRecyclerViewListener<Int> {
                return object : NutriRecyclerViewListener<Int> {
                    override fun onItemClicked(view: View, data: Int, position: Int) {
                        showToast("Click : $data")
                    }

                    override fun onItemLongClicked(view: View, data: Int, position: Int) {
                        showToast("Long Click : $data")
                    }
                }
            }

            override fun nestedCallback(): INutriViewHolder<Int> {
                return object : INutriViewHolder<Int> {
                    override fun setupInitComponent(view: View, data: Int, position: Int) {
                        Glide.with(view.context).load(NutriRvConstant.LINK_PHOTO_GITHUB)
                            .into(view.findViewById(R.id.image))
                    }
                }
            }
        })
        mAdapter.setupNestedView()
        mAdapter.setupDataNested(setupDataNested())
        binding.nutriRecyclerView.apply {
            layoutManager = mLinearLayoutManager
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Simple Nested RecyclerView")
        setupRecyclerView()
    }

}