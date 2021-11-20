package com.frogobox.nutritioncore.compose.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.frogobox.nutritioncore.compose.ui.*


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

// -------------------------------------------------------------------------------------------------
// Nutri Text Title
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriTextTitle(textContent: String) {
    Text(
        text = textContent,
        color = NutriColorPrimaryDark,
        fontWeight = FontWeight.Bold,
        fontSize = nutri_dimen_font_16sp,
        maxLines = 1
    )
}

@Composable
fun NutriTextTitle(textContent: String, colorContent: Color) {
    Text(
        text = textContent,
        color = colorContent,
        fontWeight = FontWeight.Bold,
        fontSize = nutri_dimen_font_16sp,
        maxLines = 1
    )
}


// -------------------------------------------------------------------------------------------------
// Nutri Text Sub Title
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriTextSubTitle(textContent: String) {
    Text(
        text = textContent,
        color = NutriColorBlack,
        fontSize = nutri_dimen_font_12sp,
        maxLines = 1
    )
}

@Composable
fun NutriTextSubTitle(textContent: String, colorContent: Color) {
    Text(
        text = textContent,
        color = colorContent,
        fontSize = nutri_dimen_font_12sp,
        maxLines = 1
    )
}


// -------------------------------------------------------------------------------------------------
// Nutri Text Description
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriTextDescription(textContent: String) {
    Text(
        text = textContent,
        color = NutriColorBlack,
        fontSize = nutri_dimen_font_11sp,
        maxLines = 3
    )
}

@Composable
fun NutriTextDescription(textContent: String, colorContent: Color) {
    Text(
        text = textContent,
        color = colorContent,
        fontSize = nutri_dimen_font_11sp,
        maxLines = 3
    )
}