package com.frogobox.nutritioncore.method.function

import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.method.interfaces.INutritionApi
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritioncore.sources.vitamin.VitaminRepository


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

class NutritionApi : INutritionApi {

    override fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>) {
        VitaminRepository.getVitaminA(callback)
    }

    override fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>) {
        VitaminRepository.getVitaminC(callback)
    }

    override fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>) {
        VitaminRepository.getVitaminE(callback)
    }

    override fun getBMI(weightKg: Double, heightCm: Double): Double {
        return weightKg / heightCm / heightCm * 10000
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}