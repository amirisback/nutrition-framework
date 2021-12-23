package com.frogobox.nutritioncore.sources.vitamin

import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse


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
    fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin C
    fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin E
    fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Please Add Your Code Under This Line --------------------------------------------------------

}