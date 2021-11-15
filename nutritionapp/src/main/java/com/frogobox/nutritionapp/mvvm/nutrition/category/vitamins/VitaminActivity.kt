package com.frogobox.nutritionapp.mvvm.nutrition.category.vitamins

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityVitaminBinding
import com.frogobox.nutritionapp.model.Menu
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter

class VitaminActivity : BaseActivity<ActivityVitaminBinding>() {

    override fun setupViewBinding(): ActivityVitaminBinding {
        return ActivityVitaminBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_VITAMIN)
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
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_VITAMIN_INFORMATION,
                Intent(this, VitaminInformationActivity::class.java)
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_VITAMIN_PROBLEM,
                Intent(this, VitaminProblemActivity::class.java)
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_VITAMIN_SOLVE,
                Intent(this, VitaminSolveActivity::class.java)
            )
        )
        return data
    }
}