package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.simple

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityBaseBinding
import com.frogobox.nutritionapp.model.People
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.databinding.NutriRvListType1Binding
import com.frogobox.nutritionframework.recycler.core.*

class KotlinNoAdapterActivity : BaseActivity<ActivityBaseBinding>() {

    private val dataInjectorRClass = Constant.dummyData("Injector R class")
    private val dataInjectorBinding = Constant.dummyData("Injector Binding")
    private val dataBuilderRClass = Constant.dummyData("Builder R class")
    private val dataBuilderBinding = Constant.dummyData("Builder Binding")

    override fun setupViewBinding(): ActivityBaseBinding {
        return ActivityBaseBinding.inflate(layoutInflater)
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Kotlin No Adapter")
        binding.apply {
            btnBinding.setOnClickListener {
                setupRvInjectorBinding()
            }
            btnR.setOnClickListener {
                setupRvInjector()
            }
            btnRBuilder.setOnClickListener {
                setupRvBuilder()
            }
            btnBindingBuilder.setOnClickListener {
                setupRvBuilderBinding()
            }
        }
        setupRvBuilder()
    }

    private fun setupRvInjector() {

        val adapterCallback = object :
            INutriViewAdapter<People> {
            override fun setupInitComponent(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
            }

            override fun onItemClicked(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(
                view: View,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }
        }

        binding.nutriRecyclerView.injector<People>()
            .addData(dataInjectorRClass)
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupRvInjectorBinding() {

        val adapterCallback = object : INutriBindingAdapter<People, NutriRvListType1Binding> {
            override fun setupInitComponent(
                binding: NutriRvListType1Binding,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                binding.nutriRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): NutriRvListType1Binding {
                return NutriRvListType1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun onItemClicked(
                binding: NutriRvListType1Binding,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(
                binding: NutriRvListType1Binding,
                data: People,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }
        }

        binding.nutriRecyclerView.injectorBinding<People, NutriRvListType1Binding>()
            .addData(dataInjectorBinding)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupRvBuilder() {
        binding.nutriRecyclerView.builder(object : INutriBuilderRv<People> {
            override fun setupData(): List<People> {
                // Setup data NutriRecyclerView
                return dataBuilderRClass
            }

            override fun setupCustomView(): Int {
                // Setup Custom View
                return R.layout.nutri_rv_list_type_1
            }

            override fun setupEmptyView(): Int? {
                // Setup Empty View
                return null
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                // Setup Layout Manager of NutriRecyclerView
                return NutriLayoutManager.linearLayoutVertical(context)
            }

            override fun setupInitComponent(
                view: View,
                data: People,
                position: Int,
                listener: NutriRecyclerNotifyListener<People>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
            }

            override fun onItemClicked(
                view: View,
                data: People,
                position: Int,
                listener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(
                view: View,
                data: People,
                position: Int,
                listener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }
        })
    }

    private fun setupRvBuilderBinding() {
        binding.nutriRecyclerView.builderBinding(object :
            INutriBuilderRvBinding<People, NutriRvListType1Binding> {
            override fun setupData(): List<People> {
                // Setup data NutriRecyclerView
                return dataBuilderBinding
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                // Setup Layout Manager of NutriRecyclerView
                return NutriLayoutManager.linearLayoutVertical(context)
            }

            override fun setupInitComponent(
                binding: NutriRvListType1Binding,
                data: People,
                position: Int,
                listener: NutriRecyclerNotifyListener<People>
            ) {
                binding.nutriRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): NutriRvListType1Binding {
                return NutriRvListType1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun onItemClicked(
                binding: NutriRvListType1Binding,
                data: People,
                position: Int,
                listener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(
                binding: NutriRvListType1Binding,
                data: People,
                position: Int,
                listener: NutriRecyclerNotifyListener<People>
            ) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }

        })
    }

    override fun setupViewModel() {
    }


}
