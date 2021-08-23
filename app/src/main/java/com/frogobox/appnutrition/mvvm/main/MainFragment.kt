package com.frogobox.appnutrition.mvvm.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

import com.frogobox.appnutrition.core.BaseFragment
import com.frogobox.appnutrition.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {}

    override fun setupUI(savedInstanceState: Bundle?) {
        binding?.apply {

        }
    }

}
