package com.frogobox.nutritioncore.sources.vitamin

import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritioncore.util.vitamin.VitaminUrl
import io.reactivex.Observable
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

interface VitaminApiService {

    // Get Vitamin A
    @GET(VitaminUrl.URL_VITAMIN_A)
    fun getVitaminA(): Observable<VitaminResponse>

    // Get Vitamin C
    @GET(VitaminUrl.URL_VITAMIN_C)
    fun getVitaminC(): Observable<VitaminResponse>

    // Get Vitamin E
    @GET(VitaminUrl.URL_VITAMIN_E)
    fun getVitaminE(): Observable<VitaminResponse>

}