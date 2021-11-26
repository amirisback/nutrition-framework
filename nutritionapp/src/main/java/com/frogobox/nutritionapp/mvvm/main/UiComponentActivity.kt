package com.frogobox.nutritionapp.mvvm.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityUiComponentBinding
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.mvvm.uicomponent.uicompose.MainComposeActivity
import com.frogobox.nutritionapp.mvvm.uicomponent.uixml.UiXmlRvActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionapp.util.Constant.TitleActivity.ACTIVITY_UI_COMPOSE
import com.frogobox.nutritionapp.util.Constant.TitleActivity.ACTIVITY_UI_XML_RV
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class UiComponentActivity : BaseActivity<ActivityUiComponentBinding>() {

    override fun setupViewBinding(): ActivityUiComponentBinding {
        return ActivityUiComponentBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_UI_COMPONENT)
        setupRecyclerView()
    }

    private fun data() : MutableList<Menu> {
        val data = mutableListOf<Menu>()
        data.add(Menu(ACTIVITY_UI_XML_RV, Intent(this, UiXmlRvActivity::class.java)))
        data.add(Menu(ACTIVITY_UI_COMPOSE, Intent(this, MainComposeActivity::class.java)))
        return data
    }

    private fun setupRecyclerView() {
        binding.rvUiComponent.injector<Menu>()
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(data())
            .addCallback(object : INutriViewAdapter<Menu> {
                override fun onItemClicked(data: Menu) {
                    startActivity(data.intent)
                }
                override fun onItemLongClicked(data: Menu) {}
                override fun setupInitComponent(view: View, data: Menu) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }
    
}