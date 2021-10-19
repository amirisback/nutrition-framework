package com.frogobox.nutritioncore.core

/*
 * Created by faisalamir on 26/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface NutriResponse {

    interface DataResponse<T> {
        fun onShowProgress()
        fun onHideProgress()
        fun onEmpty()
        fun onSuccess(data: T)
        fun onFailed(statusCode: Int, errorMessage: String? = "")
    }

    interface StateResponse {
        fun onSuccess()
        fun onFailed(statusCode: Int, errorMessage: String? = "")
        fun onShowProgress()
        fun onHideProgress()
    }

}