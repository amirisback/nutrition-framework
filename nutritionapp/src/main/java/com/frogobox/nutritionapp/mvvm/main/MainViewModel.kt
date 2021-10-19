package com.frogobox.nutritionapp.mvvm.main

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.frogobox.nutritioncore.model.ArticleResponse
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritionapp.util.Constant
import com.frogobox.nutritionframework.core.NutriViewModel
import com.frogobox.nutritionframework.util.NutriSingleLiveEvent
import kotlinx.coroutines.launch

/*
 * Created by Faisal Amir
 * =========================================
 * android-kick-start-project-template
 * Copyright (C) 28/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.generalframework.viewmodel
 * 
 */
class MainViewModel(private val context: Application, private val repository: DataRepository) :
    NutriViewModel(context) {

    var topHeadlineLive = NutriSingleLiveEvent<ArticleResponse>()

    fun usingChuck() {
        repository.usingChuckInterceptor(context)
    }

    fun getTopHeadline() {
        viewModelScope.launch {
            repository.getTopHeadline(
                Constant.ApiUrl.NEWS_API_KEY,
                null,
                null,
                null,
                Constant.NewsConstant.COUNTRY_ID,
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