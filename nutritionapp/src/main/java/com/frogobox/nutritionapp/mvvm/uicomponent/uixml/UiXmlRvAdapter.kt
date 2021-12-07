package com.frogobox.nutritionapp.mvvm.uicomponent.uixml

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter
/*
 * Created by faisalamir on 22/05/21
 * FrogoUIKit
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
object UiXmlRvAdapter {

    fun frogoRvAdaper(nameItemRv: String, context: Context) : INutriViewAdapter<String> {

        return when(nameItemRv) {

            "nutri_rv_list_type_1" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_1_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                    }
                }
            }

            "nutri_rv_list_type_2" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_2_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_2_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                    }
                }
            }

            "nutri_rv_list_type_3" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_3_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_3_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_3_tv_desc).text = context.getString(
                            R.string.nutri_dummy_desc
                        )
                    }
                }
            }

            "nutri_rv_list_type_4" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_4_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_4_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_5" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_5_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_5_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_5_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_6" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_6_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_6_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_6_tv_desc).text = context.getString(
                            R.string.nutri_dummy_desc
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_6_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_7" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_7_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_7_civ_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_8" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_8_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_8_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_8_civ_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_9" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_9_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_9_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_10" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_10_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_10_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_10_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_11" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_desc).text = context.getString(
                            R.string.nutri_dummy_desc
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_list_type_11_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_list_type_12" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_list_type_12_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                    }
                }
            }

            "nutri_rv_grid_type_1" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_1_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_1_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_grid_type_2" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_2_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_2_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_2_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_grid_type_3" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_3_tv_desc).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_3_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_grid_type_4" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_4_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_4_civ_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_grid_type_5" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_5_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_5_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_5_civ_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_grid_type_6" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_6_tv_title).text = context.getString(
                            R.string.nutri_dummy_title
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_6_tv_subtitle).text = context.getString(
                            R.string.nutri_dummy_subtitle
                        )
                        view.findViewById<TextView>(R.id.nutri_rv_grid_type_6_tv_desc).text = context.getString(
                            R.string.nutri_dummy_desc
                        )
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_6_civ_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            "nutri_rv_grid_type_7" -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {
                        view.findViewById<ImageView>(R.id.nutri_rv_grid_type_7_iv_poster).setImageResource(
                            R.drawable.ic_artist
                        )
                    }
                }
            }

            else -> {
                object : INutriViewAdapter<String> {
                    override fun onItemClicked(view: View, data: String, position: Int) {}
                    override fun onItemLongClicked(view: View, data: String, position: Int) {}
                    override fun setupInitComponent(view: View, data: String, position: Int) {}
                }
            }
        }


    }


}