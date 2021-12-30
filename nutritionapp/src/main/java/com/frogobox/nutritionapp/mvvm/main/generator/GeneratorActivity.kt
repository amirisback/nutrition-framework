package com.frogobox.nutritionapp.mvvm.main.generator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityGeneratorBinding
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.mvvm.main.builder.BuilderActivity
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class GeneratorActivity : BaseActivity<ActivityGeneratorBinding>() {

    private val generatorViewModel: GeneratorViewModel by viewModel()

    override fun setupViewBinding(): ActivityGeneratorBinding {
        return ActivityGeneratorBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        generatorViewModel.apply {

            setupDataMenu()

            listDataMenu.observe(this@GeneratorActivity, {
                setupRv(it)
            })
        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {
            btnNuke.setOnClickListener {
                generatorViewModel.nukePref()
                baseStartActivity<BuilderActivity>()
                finish()
            }
        }
    }

    private fun setupRv(data: List<Menu>) {
        binding.mainNutriRv.injector<Menu>()
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(data)
            .addCallback(object : INutriViewAdapter<Menu> {
                override fun onItemClicked(
                    view: View,
                    data: Menu,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<Menu>
                ) {
                    startActivity(data.intent)
                }

                override fun onItemLongClicked(
                    view: View,
                    data: Menu,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<Menu>
                ) {
                }

                override fun setupInitComponent(
                    view: View,
                    data: Menu,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<Menu>
                ) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text =
                        data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }

}