package com.frogobox.nutritionapp.mvvm.uixml

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.nutritionapp.model.Layout
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseFragment
import com.frogobox.nutritionapp.databinding.FragmentUiXmlRvListBinding
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.google.gson.Gson


class UiXmlListFragment : BaseFragment<FragmentUiXmlRvListBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUiXmlRvListBinding {
        return FragmentUiXmlRvListBinding.inflate(inflater, container, false)
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
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(UiXmlRvConstant.dataRvList())
            .addCallback(object : INutriViewAdapter<Layout> {
                override fun onItemClicked(data: Layout) { intentToLayoutSample(data) }
                override fun onItemLongClicked(data: Layout) {}
                override fun setupInitComponent(view: View, data: Layout) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }

}