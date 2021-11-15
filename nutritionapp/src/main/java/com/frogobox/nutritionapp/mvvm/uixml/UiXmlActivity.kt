package com.frogobox.nutritionapp.mvvm.uixml

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.model.Main
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityUiXmlBinding
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class UiXmlActivity : BaseActivity<ActivityUiXmlBinding>() {

    override fun setupViewBinding(): ActivityUiXmlBinding {
        return ActivityUiXmlBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupRecyclerView()
    }

    private fun data() : MutableList<Main> {
        val data = mutableListOf<Main>()
        data.add(Main("RecyclerView Layout", Intent(this, UiXmlRvActivity::class.java)))
//        data.add(Main("Compose (Experimental)", Intent(this, ComposeActivity::class.java)))
        return data
    }

    private fun setupRecyclerView() {
        binding.frogoRv.injector<Main>()
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(data())
            .addCallback(object : INutriViewAdapter<Main> {
                override fun onItemClicked(data: Main) {
                    startActivity(data.intent)
                }
                override fun onItemLongClicked(data: Main) {}
                override fun setupInitComponent(view: View, data: Main) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }
    
}