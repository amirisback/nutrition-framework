package com.frogobox.nutritionapp.core

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.frogobox.nutritionframework.admob.NutriAdmobActivity
import com.frogobox.nutritionapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 27/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.base
 *
 */
abstract class BaseActivity<VB: ViewBinding> : NutriAdmobActivity(), IBaseActivity {

    protected lateinit var binding: VB

    abstract fun setupViewBinding(): VB

    abstract fun setupViewModel()

    abstract fun setupUI(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setupViewBinding()
        setContentView(binding.root)
        setupViewModel()
        setupUI(savedInstanceState)
        setupAdmob()
    }

    private fun setupAdmob() {
        setupAdsPublisher(getString(R.string.admob_publisher_id))
        setupAdsBanner(getString(R.string.admob_banner))
        setupAdsInterstitial(getString(R.string.admob_interstitial))
        setupAdsRewarded(getString(R.string.admob_rewarded))
        setupAdsRewardedInterstitial(getString(R.string.admob_rewarded_interstitial))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setupDetailActivity(title: String) {
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
    }

    override fun setupChildFragment(frameId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(frameId, fragment)
            commit()
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setupEventEmptyView(view: View, isEmpty: Boolean) {
        if (isEmpty) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    override fun setupEventProgressView(view: View, progress: Boolean) {
        if (progress) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    override fun checkExtra(extraKey: String): Boolean {
        return intent?.hasExtra(extraKey)!!
    }

    override fun <Model> baseFragmentNewInstance(
        fragment: BaseFragment<*>,
        argumentKey: String,
        extraDataResult: Model
    ) {
        fragment.baseNewInstance(argumentKey, extraDataResult)
    }

    protected inline fun <reified ClassActivity> baseStartActivity() {
        this.startActivity(Intent(this, ClassActivity::class.java))
    }

    protected inline fun <reified ClassActivity, Model> baseStartActivity(
        extraKey: String,
        data: Model
    ) {
        val intent = Intent(this, ClassActivity::class.java)
        val extraData = Gson().toJson(data)
        intent.putExtra(extraKey, extraData)
        this.startActivity(intent)
    }

    protected inline fun <reified Model> baseGetExtraData(extraKey: String): Model {
        val extraIntent = intent.getStringExtra(extraKey)
        return Gson().fromJson(extraIntent, Model::class.java)
    }

    protected fun setupTabTitles(
        tabLayout: TabLayout,
        viewPager2: ViewPager2,
        titles: MutableList<String>
    ) {
        TabLayoutMediator(tabLayout, viewPager2) { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }

}