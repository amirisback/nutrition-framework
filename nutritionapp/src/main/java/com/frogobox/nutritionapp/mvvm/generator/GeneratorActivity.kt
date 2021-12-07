package com.frogobox.nutritionapp.mvvm.generator

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityGeneratorBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GeneratorActivity : BaseActivity<ActivityGeneratorBinding>() {

    private val generatorViewModel: GeneratorViewModel by viewModel()

    override fun setupViewBinding(): ActivityGeneratorBinding {
        return ActivityGeneratorBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        generatorViewModel.apply {

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
    }
}