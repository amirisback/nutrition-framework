package com.frogobox.nutritioncore.compose.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_16dp
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_8dp


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
// Nutri List Type 1
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType1(textContent: String) {
    Card(
        shape = RoundedCornerShape(nutri_dimen_8dp),
        modifier = Modifier
            .padding(start = nutri_dimen_16dp, end = nutri_dimen_16dp, top = nutri_dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(nutri_dimen_16dp)
        ) {
            NutriTextTitle(textContent = textContent)
        }
    }
}

