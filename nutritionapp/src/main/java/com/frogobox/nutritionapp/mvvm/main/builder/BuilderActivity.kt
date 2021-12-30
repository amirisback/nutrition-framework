package com.frogobox.nutritionapp.mvvm.main.builder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityBuilderBinding
import com.frogobox.nutritionapp.model.BuilderRes
import com.frogobox.nutritionapp.mvvm.main.generator.GeneratorActivity
import com.frogobox.nutritionframework.databinding.NutriRvSelectedListType1Binding
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.INutriBindingAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class BuilderActivity : BaseActivity<ActivityBuilderBinding>() {

    private val builderViewModel: BuilderViewModel by viewModel()

    private val rvBuilder by lazy {
        binding.rvBuilderApp.injectorBinding<BuilderRes, NutriRvSelectedListType1Binding>()
    }

    override fun setupViewBinding(): ActivityBuilderBinding {
        return ActivityBuilderBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        builderViewModel.apply {
            setupDataBuilderRes()

            listDataBuilderRes.observe(this@BuilderActivity, {
                setupRv(it)
            })
        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupButtonGenerator()
    }

    private fun setupButtonGenerator() {
        binding.btnGenerator.setOnClickListener {
            builderViewModel.savePrefBuilder()
            builderViewModel.savePrefItemBuilder(rvBuilder.nutriNotifyData())
            baseStartActivity<GeneratorActivity>()
        }
    }

    private fun setupRv(data: MutableList<BuilderRes>) {

        val rvAdapterCallback =
            object : INutriBindingAdapter<BuilderRes, NutriRvSelectedListType1Binding> {
                override fun setViewBinding(parent: ViewGroup): NutriRvSelectedListType1Binding {
                    return NutriRvSelectedListType1Binding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                }

                override fun setupInitComponent(
                    binding: NutriRvSelectedListType1Binding,
                    data: BuilderRes,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<BuilderRes>
                ) {
                    binding.apply {
                        nutriRvSelectedListType1TvTitle.text = data.name
                        nutriRvSelectedListType1IvSelected.setImageResource(R.drawable.ic_nutrition_apps)
                        if (data.value) {
                            binding.nutriRvSelectedListType1IvSelected.visibility = View.VISIBLE
                        } else {
                            binding.nutriRvSelectedListType1IvSelected.visibility = View.GONE
                        }
                    }
                }

                override fun onItemClicked(
                    binding: NutriRvSelectedListType1Binding,
                    data: BuilderRes,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<BuilderRes>
                ) {

                    if (data.value) {
                        binding.nutriRvSelectedListType1IvSelected.visibility = View.GONE
                        val tempData = BuilderRes(data.name, data.key, !data.value)
                        notifyListener.nutriNotifyItemChanged(tempData, position)
                        NLog.d("Status ${notifyListener.nutriNotifyData()[position].value}")
                    } else {
                        binding.nutriRvSelectedListType1IvSelected.visibility = View.VISIBLE
                        val tempData = BuilderRes(data.name, data.key, !data.value)
                        notifyListener.nutriNotifyItemChanged(tempData, position)
                        NLog.d("Status ${notifyListener.nutriNotifyData()[position].value}")
                    }

                }

                override fun onItemLongClicked(
                    binding: NutriRvSelectedListType1Binding,
                    data: BuilderRes,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<BuilderRes>
                ) {

                }

            }

        rvBuilder.addData(data)
            .createLayoutLinearVertical(false)
            .addCallback(rvAdapterCallback)
            .build()
    }

    private fun setupGenerated(valueState: Boolean) {
        if (valueState) {
            baseStartActivity<GeneratorActivity>()
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        setupGenerated(builderViewModel.getPrefBuilder())
    }

}