package com.frogobox.nutritionapp.mvvm.nutrition.vitamin

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.frogobox.nutritionapp.source.DataRepository
import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritionframework.core.NutriViewModel
import com.frogobox.nutritionframework.util.NutriSingleLiveEvent
import kotlinx.coroutines.launch


/*
 * Created by faisalamir on 30/11/21
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

class VitaminViewModel(
    private val context: Application,
    private val repository: DataRepository
) :
    NutriViewModel(context) {

    val dataVitamin = NutriSingleLiveEvent<VitaminResponse>()

    fun getVitaminA() {
        repository.getVitaminA(object : NutriResponse.DataResponse<VitaminResponse> {
            override fun onSuccess(data: VitaminResponse) {
                dataVitamin.postValue(data)
            }

            override fun onFailed(statusCode: Int, errorMessage: String?) {
                // on Failed
                eventFailed.postValue(errorMessage)
            }

            override fun onShowProgress() {
                // Show Your Progress View
                eventShowProgress.postValue(true)
            }

            override fun onHideProgress() {
                // Hide Your Progress View
                eventShowProgress.postValue(false)
            }

            override fun onEmpty() {
                //
            }
        })
    }

    fun getVitaminC() {
        viewModelScope.launch {
            repository.getVitaminC(object : NutriResponse.DataResponse<VitaminResponse> {
                override fun onSuccess(data: VitaminResponse) {
                    dataVitamin.postValue(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    // on Failed
                    eventFailed.postValue(errorMessage)
                }

                override fun onShowProgress() {
                    // Show Your Progress View
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    // Hide Your Progress View
                    eventShowProgress.postValue(false)
                }

                override fun onEmpty() {
                    //
                }
            })
        }
    }

    fun getVitaminE() {
        viewModelScope.launch {
            repository.getVitaminE(object : NutriResponse.DataResponse<VitaminResponse> {
                override fun onSuccess(data: VitaminResponse) {
                    dataVitamin.postValue(data)
                }

                override fun onFailed(statusCode: Int, errorMessage: String?) {
                    // on Failed
                    eventFailed.postValue(errorMessage)
                }

                override fun onShowProgress() {
                    // Show Your Progress View
                    eventShowProgress.postValue(true)
                }

                override fun onHideProgress() {
                    // Hide Your Progress View
                    eventShowProgress.postValue(false)
                }

                override fun onEmpty() {
                    //
                }
            })
        }
    }

}