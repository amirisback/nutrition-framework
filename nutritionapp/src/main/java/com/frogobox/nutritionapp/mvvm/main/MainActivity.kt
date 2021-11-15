package com.frogobox.nutritionapp.mvvm.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityMainBinding
import com.frogobox.nutritionapp.model.Main
import com.frogobox.nutritionapp.mvvm.nutrition.article.NutritionArticleActivity
import com.frogobox.nutritionapp.mvvm.uixml.UiXmlActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    private fun data(): MutableList<Main> {
        val data = mutableListOf<Main>()
        data.add(Main(Constant.TitleActivity.ACTIVITY_UI_XML, Intent(this, UiXmlActivity::class.java)))
        data.add(Main(Constant.TitleActivity.ACTIVITY_NUTRITION_ARTICLE, Intent(this, NutritionArticleActivity::class.java)))
        return data
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {
            mainNutriRv.injector<Main>()
                .addCustomView(R.layout.nutri_rv_list_type_1)
                .addData(data())
                .addCallback(object : INutriViewAdapter<Main> {
                    override fun onItemClicked(data: Main) {
                        startActivity(data.intent)
                    }

                    override fun onItemLongClicked(data: Main) {}
                    override fun setupInitComponent(view: View, data: Main) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text =
                            data.name
                    }
                })
                .createLayoutLinearVertical(false)
                .build()
        }
    }

}