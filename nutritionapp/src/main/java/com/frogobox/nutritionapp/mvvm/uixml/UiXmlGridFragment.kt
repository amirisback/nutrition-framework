package com.frogobox.nutritionapp.mvvm.uixml

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.frogobox.nutritionapp.model.Layout
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseFragment
import com.frogobox.nutritionapp.databinding.FragmentUiXmlRvGridBinding
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.google.gson.Gson

class UiXmlGridFragment : BaseFragment<FragmentUiXmlRvGridBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUiXmlRvGridBinding {
        return FragmentUiXmlRvGridBinding.inflate(inflater, container, false)
    }

    override fun setupViewModel() {
        //
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupRecyclerView()
    }

    private fun intentToLayoutSample(data: Layout) {
        val dataString = Gson().toJson(data)
        val intent = Intent(mActivity, UiXmlRvDetailActivity::class.java)
        intent.putExtra("EXTRA_DATA", dataString)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        binding.nutriRv.injector<Layout>()
            .addCustomView(R.layout.nutri_rv_grid_type_1)
            .addData(UiXmlRvConstant.dataRvGrid())
            .addCallback(object : INutriViewAdapter<Layout> {
                override fun onItemClicked(data: Layout) { intentToLayoutSample(data) }
                override fun onItemLongClicked(data: Layout) {}
                override fun setupInitComponent(view: View, data: Layout) {
                    view.findViewById<TextView>(R.id.nutri_rv_grid_type_1_tv_title).text = data.name
                    view.findViewById<ImageView>(R.id.nutri_rv_grid_type_1_iv_poster)
                        .setImageResource(R.drawable.ic_artist)
                }
            })
            .createLayoutGrid(2)
            .build()
    }

}