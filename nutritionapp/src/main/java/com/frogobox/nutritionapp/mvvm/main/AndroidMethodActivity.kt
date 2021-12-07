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
import com.frogobox.nutritionapp.mvvm.androidmethod.log.NutriLogSampleActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.notification.NutriNotificationSampleActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.recycler.NutriRecyclerSampleActivity
import com.frogobox.nutritionapp.mvvm.nutrition.article.ArticleCategoryActivity
import com.frogobox.nutritionapp.mvvm.nutrition.meal.MealActivity
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener

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

    private fun data(): MutableList<Menu> {
        val data = mutableListOf<Menu>()
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_RV,
                Intent(this, NutriRecyclerSampleActivity::class.java)
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_LOG,
                Intent(this, NutriLogSampleActivity::class.java)
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_NOTIF,
                Intent(this, NutriNotificationSampleActivity::class.java)
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_ADMOB,
                Intent(this, NutriAdmobSampleActivity::class.java)
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_API_NEWS,
                Intent(this, ArticleCategoryActivity::class.java).putExtra(
                    Constant.Extra.EXTRA_ARTICLE_TITLE,
                    Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_A
                )
                    .putExtra(
                        Constant.Extra.EXTRA_ARTICLE_DETAIL_TITLE,
                        Constant.TitleActivity.ACTIVITY_VITAMIN_ARTICLE_A
                    )
                    .putExtra(Constant.Extra.EXTRA_ARTICLE, "Nutrisi")
            )
        )
        data.add(
            Menu(
                Constant.TitleActivity.ACTIVITY_ANDROID_METHOD_API_MEALS,
                Intent(this, MealActivity::class.java)
            )
        )
        return data
    }

    private fun setupRecyclerView() {
        binding.rvAndroidMethod.injector<Menu>()
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(data())
            .addCallback(object : INutriViewAdapter<Menu> {
                override fun onItemClicked(
                    view: View,
                    data: Menu,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<Menu>
                ) {
                    startActivity(data.intent)
                }

                override fun onItemLongClicked(
                    view: View,
                    data: Menu,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<Menu>
                ) {
                }

                override fun setupInitComponent(
                    view: View,
                    data: Menu,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<Menu>
                ) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }

}