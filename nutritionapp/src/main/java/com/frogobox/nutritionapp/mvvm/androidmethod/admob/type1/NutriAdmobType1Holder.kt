package com.frogobox.nutritionapp.mvvm.androidmethod.admob.type1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.nutritionapp.R
import com.frogobox.nutritioncore.model.news.Article
import com.frogobox.nutritionframework.admob.NutriAdmobViewHolder
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener


/*
 * Created by faisalamir on 26/11/21
 * NutritionFramework
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

class NutriAdmobType1Holder(view: View) : NutriAdmobViewHolder<Any>(view) {

    private val tv_title = view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_title)
    private val tv_subtitle = view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_subtitle)
    private val tv_desc = view.findViewById<TextView>(R.id.nutri_rv_list_type_11_tv_desc)
    private val iv_poster = view.findViewById<ImageView>(R.id.nutri_rv_list_type_11_iv_poster)

    override fun initComponent(
        data: Any,
        position: Int,
        listener: NutriRecyclerNotifyListener<Any>
    ) {
        val article = data as Article
        Glide.with(itemView.context).load(article.urlToImage).into(iv_poster)
        tv_title.text = article.title
        tv_desc.text = article.description
        tv_subtitle.text = article.author
    }
}