package com.frogobox.generalframework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.frogobox.generalframework.databinding.ActivityMainBinding
import com.frogobox.recycler.core.IFrogoViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        binding.apply {

            frogoRv.injector<String>()
                    .addData(name())
                    .addCustomView(R.layout.frogo_rv_list_type_1)
                    .addCallback(object: IFrogoViewAdapter<String>{
                        override fun onItemClicked(data: String) {

                        }

                        override fun onItemLongClicked(data: String) {
                            // TODO("Not yet implemented")
                        }

                        override fun setupInitComponent(view: View, data: String) {
                            val textRV = view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title)
                            textRV.text = data
                        }
                    })
                    .createLayoutLinearVertical(false)
                    .build()

        }


    }


    private fun name() : MutableList<String> {
        val listData = mutableListOf<String>()
        listData.add("Aplikasi Nutrisi")
        listData.add("Aplikasi Nutrisi")
        listData.add("Aplikasi Nutrisi")
        listData.add("Aplikasi Nutrisi")
        return listData
    }

}