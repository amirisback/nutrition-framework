package com.frogobox.nutritionapp.mvvm.nutrition.meal

import android.os.Bundle
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityMealDetailBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.meal.Meal
import com.google.gson.Gson

class MealDetailActivity : BaseActivity<ActivityMealDetailBinding>() {

    private val extraDataContent by lazy {
        Gson().fromJson(
            intent.getStringExtra(Constant.Extra.EXTRA_MEAL_DETAIL),
            Meal::class.java
        )
    }

    override fun setupViewBinding(): ActivityMealDetailBinding {
        return ActivityMealDetailBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        extraDataContent.strMeal?.let { setupDetailActivity(it) }
        binding.apply {
            tvTitle.text = extraDataContent.strCategory
            tvOverview.append("${extraDataContent.strIngredient1}")
            tvOverview.append("\n${extraDataContent.strIngredient2}")
            tvOverview.append("\n${extraDataContent.strIngredient3}")
            tvOverview.append("\n${extraDataContent.strIngredient4}")
            tvOverview.append("\n${extraDataContent.strIngredient5}")
            tvOverview.append("\n${extraDataContent.strIngredient6}")
            tvOverview.append("\n${extraDataContent.strIngredient7}")
            tvOverview.append("\n${extraDataContent.strIngredient8}")
            tvOverview.append("\n${extraDataContent.strIngredient9}")
            tvOverview.append("\n${extraDataContent.strIngredient10}")
            Glide.with(this@MealDetailActivity).load(extraDataContent.strMealThumb).into(ivPoster)
        }
    }
}