package com.frogobox.nutritionapp.mvvm.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityMainBinding
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.CalculatorNutritionActivity
import com.frogobox.nutritionapp.mvvm.nutrition.meal.MealActivity
import com.frogobox.nutritionapp.mvvm.uixml.UiXmlActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {
            mainNutriRv.injector<Menu>()
                .addCustomView(R.layout.nutri_rv_list_type_1)
                .addData(data())
                .addCallback(object : INutriViewAdapter<Menu> {
                    override fun onItemClicked(data: Menu) {
                        startActivity(data.intent)
                    }
                    override fun onItemLongClicked(data: Menu) {}
                    override fun setupInitComponent(view: View, data: Menu) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text =
                            data.name
                    }
                })
                .createLayoutLinearVertical(false)
                .build()
        }
    }

    private fun data(): MutableList<Menu> {
        val data = mutableListOf<Menu>()
        data.add(Menu(Constant.TitleActivity.ACTIVITY_UI_XML, Intent(this, UiXmlActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ARTICLE, Intent(this, ArticleActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_MEAL, Intent(this, MealActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_CALCULATOR, Intent(this, CalculatorNutritionActivity::class.java)))
        return data
    }

}