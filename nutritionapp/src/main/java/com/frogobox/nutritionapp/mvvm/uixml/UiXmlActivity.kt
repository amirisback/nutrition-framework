package com.frogobox.nutritionapp.mvvm.uixml

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.compose.ui.unit.Constraints
import com.frogobox.nutritionapp.model.UiXml
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityUiXmlBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class UiXmlActivity : BaseActivity<ActivityUiXmlBinding>() {

    override fun setupViewBinding(): ActivityUiXmlBinding {
        return ActivityUiXmlBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_UI_XML)
        setupRecyclerView()
    }

    private fun data() : MutableList<UiXml> {
        val data = mutableListOf<UiXml>()
        data.add(UiXml("RecyclerView Layout", Intent(this, UiXmlRvActivity::class.java)))
//        data.add(Main("Compose (Experimental)", Intent(this, ComposeActivity::class.java)))
        return data
    }

    private fun setupRecyclerView() {
        binding.uiXmlNutriRv.injector<UiXml>()
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(data())
            .addCallback(object : INutriViewAdapter<UiXml> {
                override fun onItemClicked(data: UiXml) {
                    startActivity(data.intent)
                }
                override fun onItemLongClicked(data: UiXml) {}
                override fun setupInitComponent(view: View, data: UiXml) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }
    
}