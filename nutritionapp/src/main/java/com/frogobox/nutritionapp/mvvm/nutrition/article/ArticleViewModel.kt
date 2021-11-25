package com.frogobox.nutritionapp.mvvm.nutrition.article

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritioncore.method.function.ConsumeNewsApi
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.util.news.NewsConstant
import com.frogobox.nutritionframework.core.NutriViewModel
import com.frogobox.nutritionframework.util.NutriSingleLiveEvent
import kotlinx.coroutines.launch


/*
 * Created by faisalamir on 15/11/21
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

class ArticleViewModel(
    private val context: Application,
    private val consumeNewsApi: ConsumeNewsApi
) :
    NutriViewModel(context) {

    var topHeadlineLive = NutriSingleLiveEvent<ArticleResponse>()

    fun getEverythings(query: String) {
        viewModelScope.launch {
            consumeNewsApi.getEverythings(
                query,
                null,
                null,
                null,
                null,
                null,
                null,
                NewsConstant.COUNTRY_ID,
                null,
                null,
                null,
                object : DataSource.GetRemoteCallback<ArticleResponse> {
                    override fun onShowProgress() {
                        eventShowProgress.postValue(true)
                    }

                    override fun onHideProgress() {
                        eventShowProgress.postValue(false)
                    }

                    override fun onEmpty() {}

                    override fun onSuccess(data: ArticleResponse) {
                        topHeadlineLive.postValue(data)
                    }

                    override fun onFailed(statusCode: Int, errorMessage: String?) {}
                }
            )
        }
    }
}