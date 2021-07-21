package com.frogobox.app.core

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdView
import com.google.gson.Gson

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 25/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.activity
 *
 */
abstract class BaseFragment : Fragment(),
    IBaseFragment {

    lateinit var mBaseActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBaseActivity = (activity as BaseActivity)
    }

    override fun setupShowAdsInterstitial() {
        mBaseActivity.setupShowAdsInterstitial()
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        mBaseActivity.setupShowAdsBanner(mAdView)
    }

    override fun setupChildFragment(frameId: Int, fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            replace(frameId, fragment)
            commit()
        }
    }

    override fun checkArgument(argsKey: String): Boolean {
        return requireArguments().containsKey(argsKey)
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

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun <Model> baseNewInstance(argsKey: String, data: Model) {
        val argsData = Gson().toJson(data)
        val bundleArgs = Bundle().apply {
            putString(argsKey, argsData)
        }
        this.arguments = bundleArgs
    }

    protected inline fun <reified Model> baseGetInstance(argsKey: String): Model {
        val argsData = this.arguments?.getString(argsKey)
        return Gson().fromJson(argsData, Model::class.java)
    }

    protected inline fun <reified ClassActivity> baseStartActivity() {
        context?.startActivity(Intent(context, ClassActivity::class.java))
    }

    protected inline fun <reified ClassActivity, Model> baseStartActivity(
        extraKey: String,
        data: Model
    ) {
        val intent = Intent(context, ClassActivity::class.java)
        val extraData = Gson().toJson(data)
        intent.putExtra(extraKey, extraData)
        this.startActivity(intent)
    }

}