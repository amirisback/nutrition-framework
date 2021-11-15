package com.frogobox.nutritionapp.mvvm.nutrition.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutritionMealBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.meal.Meal
import com.frogobox.nutritionframework.databinding.NutriRvGridType2Binding
import com.frogobox.nutritionframework.recycler.core.INutriBindingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NutritionMealActivity : BaseActivity<ActivityNutritionMealBinding>() {

    private val mealViewModel: NutritionMealViewModel by viewModel()
    
    override fun setupViewBinding(): ActivityNutritionMealBinding {
        return ActivityNutritionMealBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        mealViewModel.apply {
            getListMeals("b")

            eventShowProgress.observe(this@NutritionMealActivity, {
                setupEventProgressView(binding.progressBar, it)
            })

            eventFailed.observe(this@NutritionMealActivity, {
                showToast(it)
            })

            listData.observe(this@NutritionMealActivity, {
                setupRv(it)
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_MEAL)
        binding.apply {

        }
    }

    private fun setupRv(data: List<Meal>) {

        val adapterCallback = object : INutriBindingAdapter<Meal, NutriRvGridType2Binding> {

            override fun setViewBinding(parent: ViewGroup): NutriRvGridType2Binding {
                return NutriRvGridType2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun setupInitComponent(binding: NutriRvGridType2Binding, data: Meal) {
                binding.apply {
                    Glide.with(root.context).load(data.strMealThumb).into(nutriRvGridType2IvPoster)
                    nutriRvGridType2TvTitle.text = data.strMeal
                    nutriRvGridType2TvSubtitle.text = data.strCategory
                }
            }

            override fun onItemClicked(data: Meal) {
                data.strMeal?.let { showToast(it) }
            }

            override fun onItemLongClicked(data: Meal) {
                data.strMeal?.let { showToast(it) }
            }

        }

        binding.frogoRv.injectorBinding<Meal, NutriRvGridType2Binding>()
            .addData(data)
            .addCallback(adapterCallback)
            .createLayoutGrid(2)
            .build()
    }

}