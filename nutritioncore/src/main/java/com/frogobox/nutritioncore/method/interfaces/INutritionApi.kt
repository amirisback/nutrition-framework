package com.frogobox.nutritioncore.method.interfaces

import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse


/*
 * Created by faisalamir on 12/11/21
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

interface INutritionApi {

    // Get Vitamin A
    fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin C
    fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get Vitamin E
    fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>)

    // Get BMI Kg/m2
    fun getBMI(weightKg: Double, heightCm: Double) : Double

    // Please Add Your Code Under This Line --------------------------------------------------------


}