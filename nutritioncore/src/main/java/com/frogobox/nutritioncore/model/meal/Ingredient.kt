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
data class Ingredient(

    @SerializedName("idIngredient")
    var idIngredient: String? = null,

    @SerializedName("strIngredient")
    var strIngredient: String? = null,

    @SerializedName("strDescription")
    var strDescription: String? = null,

    @SerializedName("strType")
    var strType: String? = null

)