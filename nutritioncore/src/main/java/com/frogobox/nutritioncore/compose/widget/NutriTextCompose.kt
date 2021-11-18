package com.frogobox.nutritioncore.compose.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.frogobox.nutritioncore.compose.ui.NutriColorPrimaryDark
import com.frogobox.nutritioncore.compose.ui.nutri_font_dimen_16sp


/*
 * Created by faisalamir on 18/11/21
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

@Composable
fun NutriTextTitle(content: String) {

    Text(
        text = content,
        color = NutriColorPrimaryDark,
        fontWeight = FontWeight.Bold,
        fontSize = nutri_font_dimen_16sp
    )

}