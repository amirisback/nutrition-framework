package com.frogobox.nutritionapp.mvvm.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityMainBinding
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.BeratBadanIdealActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.IndexMasaTubuhActivity
import com.frogobox.nutritionapp.mvvm.nutrition.general.KebutuhanEnergiActivity
import com.frogobox.nutritionapp.mvvm.nutrition.meal.MealActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel : MainViewModel by viewModel()

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        mainViewModel.apply {
            prefSample.observe(this@MainActivity, {
                NLog.d("Pref Sample $it")
            })
        }
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
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                    }
                })
                .createLayoutLinearVertical(false)
                .build()
        }
    }

    private fun data(): MutableList<Menu> {
        val data = mutableListOf<Menu>()
        data.add(Menu(Constant.TitleActivity.ACTIVITY_UI_COMPONENT, Intent(this, UiComponentActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ANDROID_METHOD, Intent(this, AndroidMethodActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_ARTICLE, Intent(this, ArticleActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_MEAL, Intent(this, MealActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI, Intent(this, KebutuhanEnergiActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH, Intent(this, IndexMasaTubuhActivity::class.java)))
        data.add(Menu(Constant.TitleActivity.ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL, Intent(this, BeratBadanIdealActivity::class.java)))
        return data
    }

}