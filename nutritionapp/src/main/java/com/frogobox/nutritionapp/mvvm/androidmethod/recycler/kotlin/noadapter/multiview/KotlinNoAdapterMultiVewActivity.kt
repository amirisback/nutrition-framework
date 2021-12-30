package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.multiview

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityFrogoRvGridBinding
import com.frogobox.nutritionapp.model.People
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.*

class KotlinNoAdapterMultiVewActivity : BaseActivity<ActivityFrogoRvGridBinding>() {

    override fun setupViewBinding(): ActivityFrogoRvGridBinding {
        return ActivityFrogoRvGridBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Kotlin No Adapter - Multi View")
        setupNutriRecyclerView()
    }

    private fun firstCallback(): INutriViewHolder<People> {
        return object : INutriViewHolder<People> {
            override fun setupInitComponent(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.nutri_rv_grid_type_1_tv_title).text = data.name
                Glide.with(view.context).load(NutriRvConstant.LINK_PHOTO_GITHUB)
                    .into(view.findViewById(R.id.nutri_rv_grid_type_1_iv_poster))
            }
        }
    }

    private fun secondCallback(): INutriViewHolder<People> {
        return object : INutriViewHolder<People> {
            override fun setupInitComponent(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_title).text = data.name
                view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_subtitle).text = data.name
                view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_desc).text =
                    NutriRvConstant.DUMMY_LOREM_IPSUM

                Glide.with(view.context).load(NutriRvConstant.LINK_PHOTO_GITHUB)
                    .into(view.findViewById<ImageView>(R.id.nutri_rv_grid_type_3_iv_poster))
            }
        }
    }

    private fun firstListenerType(): NutriRecyclerViewListener<People> {
        return object : NutriRecyclerViewListener<People> {
            override fun onItemClicked(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                showToast(data.name + " First")
            }

            override fun onItemLongClicked(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                showToast("LAYOUT TYPE 1")
            }
        }
    }

    private fun secondListenerType(): NutriRecyclerViewListener<People> {
        return object : NutriRecyclerViewListener<People> {
            override fun onItemClicked(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                showToast(data.name + " Second")
            }

            override fun onItemLongClicked(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                showToast("LAYOUT TYPE 2")
            }
        }
    }

    private fun data(): MutableList<NutriHolder<People>> {
        val data = mutableListOf<NutriHolder<People>>()
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(NutriHolder(People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        return data
    }

    private fun setupNutriRecyclerView() {
        binding.nutriRecyclerView
            .injector<People>()
            .addDataFH(data())
            .createLayoutStaggeredGrid(2)
            .build()
    }

}