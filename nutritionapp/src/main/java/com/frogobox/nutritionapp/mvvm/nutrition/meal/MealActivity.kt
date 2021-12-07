package com.frogobox.nutritionapp.mvvm.nutrition.meal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityMealBinding
import com.frogobox.nutritionapp.databinding.ItemMealCategoryBinding
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritioncore.model.meal.Meal
import com.frogobox.nutritioncore.util.NutriFunc
import com.frogobox.nutritionframework.databinding.NutriRvGridType2Binding
import com.frogobox.nutritionframework.recycler.core.INutriBindingAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealActivity : BaseActivity<ActivityMealBinding>() {

    private val mealViewModel: MealViewModel by viewModel()

    override fun setupViewBinding(): ActivityMealBinding {
        return ActivityMealBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        mealViewModel.apply {
            getListMeals("b")

            eventShowProgress.observe(this@MealActivity, {
                setupEventProgressView(binding.progressBar, it)
            })

            eventFailed.observe(this@MealActivity, {
                showToast(it)
            })

            listData.observe(this@MealActivity, {
                setupRv(it)
            })

        }
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity(Constant.TitleActivity.ACTIVITY_MEAL)
        binding.apply {
            setupRvCategory()
        }
    }

    private fun setupRvCategory() {
        val adapterCallback = object : INutriBindingAdapter<String, ItemMealCategoryBinding> {
            override fun setViewBinding(parent: ViewGroup): ItemMealCategoryBinding {
                return ItemMealCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun setupInitComponent(
                binding: ItemMealCategoryBinding,
                data: String,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<String>
            ) {
                binding.nutriRvListType12TvTitle.text = data
            }

            override fun onItemClicked(
                binding: ItemMealCategoryBinding,
                data: String,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<String>
            ) {
                mealViewModel.getListMeals(data)
            }

            override fun onItemLongClicked(
                binding: ItemMealCategoryBinding,
                data: String,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<String>
            ) {
                //
            }
        }

        binding.nutriRvAbjad.injectorBinding<String, ItemMealCategoryBinding>()
            .addData(NutriFunc.arrayAbjad())
            .addCallback(adapterCallback)
            .createLayoutLinearHorizontal(false)
            .build()

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

            override fun setupInitComponent(
                binding: NutriRvGridType2Binding,
                data: Meal,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Meal>
            ) {
                binding.apply {
                    Glide.with(root.context).load(data.strMealThumb).into(nutriRvGridType2IvPoster)
                    nutriRvGridType2TvTitle.text = data.strMeal
                    nutriRvGridType2TvSubtitle.text = data.strCategory
                }
            }

            override fun onItemClicked(
                binding: NutriRvGridType2Binding,
                data: Meal,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Meal>
            ) {
                val extraData = Gson().toJson(data)
                val intent = Intent(this@MealActivity, MealDetailActivity::class.java)
                    .putExtra(Constant.Extra.EXTRA_MEAL_DETAIL, extraData)
                startActivity(intent)
            }

            override fun onItemLongClicked(
                binding: NutriRvGridType2Binding,
                data: Meal,
                position: Int,
                notifyListener: NutriRecyclerNotifyListener<Meal>
            ) {
                data.strMeal?.let { showToast(it) }
            }

        }

        binding.nutriRv.injectorBinding<Meal, NutriRvGridType2Binding>()
            .addData(data)
            .addCallback(adapterCallback)
            .createLayoutGrid(2)
            .build()
    }

}