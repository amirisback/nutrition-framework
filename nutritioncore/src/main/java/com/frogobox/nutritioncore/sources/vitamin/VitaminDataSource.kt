package com.frogobox.nutritioncore.sources.vitamin

import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritioncore.util.vitamin.VitaminUrl
import retrofit2.http.GET


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

interface VitaminDataSource {

    // Get Vitamin A
    suspend fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin C
    suspend fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin E
    suspend fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Please Add Your Code Under This Line --------------------------------------------------------

}