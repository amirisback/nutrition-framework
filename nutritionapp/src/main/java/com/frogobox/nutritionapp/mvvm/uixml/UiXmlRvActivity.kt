package com.frogobox.nutritionapp.mvvm.uixml

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.core.BasePagerAdapter
import com.frogobox.nutritionapp.databinding.ActivityUiXmlRvBinding

class UiXmlRvActivity : BaseActivity<ActivityUiXmlRvBinding>() {

    override fun setupViewBinding(): ActivityUiXmlRvBinding {
        return ActivityUiXmlRvBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("List UI RecyclerView")
        setupViewPager()
    }

    private fun setupViewPager() {
        val pagerAdapter = BasePagerAdapter(this)
        pagerAdapter.setupPagerFragment(UiXmlListFragment(), "List")
        pagerAdapter.setupPagerFragment(UiXmlGridFragment(),"Grid")

        binding.apply {
            viewpager.adapter = pagerAdapter
            setupTabTitles(tablayout, viewpager, pagerAdapter.titles)
        }
    }



}