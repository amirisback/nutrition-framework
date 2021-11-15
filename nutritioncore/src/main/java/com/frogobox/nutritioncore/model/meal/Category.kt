package com.frogobox.nutritioncore.model.meal

import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * TheMealsAPI
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoconsumeapi.meal.data.model
 *
 */
data class Category(

    @SerializedName("idCategory")
    var idCategory: String? = null,

    @SerializedName("strCategory")
    var strCategory: String? = null,

    @SerializedName("strCategoryThumb")
    var strCategoryThumb: String? = null,

    @SerializedName("strCategoryDescription")
    var strCategoryDescription: String? = null

)