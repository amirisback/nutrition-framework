package com.frogobox.nutritionapp.mvvm.uixml

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityUiXmlBinding
import com.frogobox.nutritionapp.model.Menu
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

    private fun data() : MutableList<Menu> {
        val data = mutableListOf<Menu>()
        data.add(Menu("RecyclerView Layout", Intent(this, UiXmlRvActivity::class.java)))
//        data.add(Main("Compose (Experimental)", Intent(this, ComposeActivity::class.java)))
        return data
    }

    private fun setupRecyclerView() {
        binding.uiXmlNutriRv.injector<Menu>()
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