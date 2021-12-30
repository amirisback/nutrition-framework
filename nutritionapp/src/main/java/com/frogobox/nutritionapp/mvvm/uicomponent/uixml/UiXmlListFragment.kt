package com.frogobox.nutritionapp.mvvm.uicomponent.uixml

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseFragment
import com.frogobox.nutritionframework.databinding.FragmentUiXmlRvListBinding
import com.frogobox.nutritionapp.model.LayoutUiXml
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener
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

    private fun intentToLayoutSample(data: LayoutUiXml) {
        val dataString = Gson().toJson(data)
        val intent = Intent(mActivity, UiXmlRvDetailActivity::class.java)
        intent.putExtra("EXTRA_DATA", dataString)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        binding.nutriRv.injector<LayoutUiXml>()
            .addCustomView(R.layout.nutri_rv_list_type_1)
            .addData(UiXmlRvConstant.dataRvList())
            .addCallback(object : INutriViewAdapter<LayoutUiXml> {
                override fun onItemClicked(
                    view: View,
                    data: LayoutUiXml,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<LayoutUiXml>
                ) {
                    intentToLayoutSample(data)
                }

                override fun onItemLongClicked(
                    view: View,
                    data: LayoutUiXml,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<LayoutUiXml>
                ) {
                }

                override fun setupInitComponent(
                    view: View,
                    data: LayoutUiXml,
                    position: Int,
                    notifyListener: NutriRecyclerNotifyListener<LayoutUiXml>
                ) {
                    view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = data.name
                }
            })
            .createLayoutLinearVertical(false)
            .build()
    }

}