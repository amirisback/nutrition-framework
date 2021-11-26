package com.frogobox.nutritionapp.mvvm.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityAndroidMethodBinding
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.mvvm.androidmethod.admob.NutriAdmobSampleActivity
import com.frogobox.nutritionapp.mvvm.uicomponent.uixml.UiXmlRvActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class AndroidMethodActivity : BaseActivity<ActivityAndroidMethodBinding>() {

    override fun setupViewBinding(): ActivityAndroidMethodBinding {
        return ActivityAndroidMethodBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD)
        setupRecyclerView()
    }

    private fun data() : MutableList<Menu> {
        val data = mutableListOf<Menu>()
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_RV, Intent(this, UiXmlRvActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_LOG, Intent(this, UiXmlRvActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_NOTIF, Intent(this, UiXmlRvActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_ADMOB, Intent(this, NutriAdmobSampleActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_API_NEWS, Intent(this, UiXmlRvActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_API_MEALS, Intent(this, UiXmlRvActivity::class.java)))
        return data
    }

    private fun setupRecyclerView() {
        binding.rvAndroidMethod.injector<Menu>()
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