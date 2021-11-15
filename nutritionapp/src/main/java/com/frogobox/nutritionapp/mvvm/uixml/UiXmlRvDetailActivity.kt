package com.frogobox.nutritionapp.mvvm.uixml

import android.os.Bundle
import androidx.core.view.updatePadding
import com.frogobox.nutritionapp.mvvm.uixml.UiXmlRvConstant.TYPE_GRID
import com.frogobox.nutritionapp.mvvm.uixml.UiXmlRvConstant.dummyData
import com.frogobox.nutritionapp.mvvm.uixml.UiXmlRvAdapter.frogoRvAdaper
import com.frogobox.nutritionapp.model.LayoutUiXml
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityUiXmlRvDetailBinding
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.google.gson.Gson

class UiXmlRvDetailActivity : BaseActivity<ActivityUiXmlRvDetailBinding>() {

    override fun setupViewBinding(): ActivityUiXmlRvDetailBinding {
        return ActivityUiXmlRvDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(extraData().name)
        setupRecyclerView(frogoRv())
    }

    private fun extraData() : LayoutUiXml {
        val extra = intent.getStringExtra("EXTRA_DATA")
        return Gson().fromJson(extra, LayoutUiXml::class.java)
    }

    private fun frogoRv() : INutriViewAdapter<String> {
        return frogoRvAdaper(extraData().name, this)
    }
    
    private fun setupRecyclerView(adapter: INutriViewAdapter<String>) {

        val scale = resources.displayMetrics.density
        val dpAsPixels = (16 * scale + 0.5f)

        if (extraData().type == TYPE_GRID) {
            binding.nutriRv.apply {
                injector<String>()
                    .addCustomView(extraData().layout)
                    .addCallback(adapter)
                    .addData(dummyData())
                    .createLayoutGrid(2)
                    .build()

                updatePadding(left = dpAsPixels.toInt())
            }
        } else {
            binding.nutriRv.injector<String>()
                .addCustomView(extraData().layout)
                .addCallback(adapter)
                .addData(dummyData())
                .createLayoutLinearVertical(false)
                .build()
        }

    }

}