package com.frogobox.nutritioncore.compose.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_16dp
import com.frogobox.nutritioncore.compose.ui.nutri_dimen_8dp


/*
 * Created by faisalamir on 20/11/21
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
// Nutri Grid Type 1 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriGridType1(imageUrlContent: String, titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(nutri_dimen_8dp),
        modifier = Modifier
            .padding(end = nutri_dimen_16dp, top = nutri_dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(nutri_dimen_16dp)
        ) {
            Column {
                NutriImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_8dp))
                NutriTextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri Grid Type 2 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriGridType2(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(nutri_dimen_8dp),
        modifier = Modifier
            .padding(end = nutri_dimen_16dp, top = nutri_dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(nutri_dimen_16dp)
        ) {
            Column {
                NutriImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_8dp))
                NutriTextTitle(titleTextContent)
                NutriTextSubTitle(subTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri Grid Type 3 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriGridType3(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
) {
    Card(
        shape = RoundedCornerShape(nutri_dimen_8dp),
        modifier = Modifier
            .padding(end = nutri_dimen_16dp, top = nutri_dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(nutri_dimen_16dp)
        ) {
            Column {
                NutriImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_8dp))
                NutriTextTitle(titleTextContent)
                NutriTextSubTitle(subTitleTextContent)
                Spacer(modifier = Modifier.size(nutri_dimen_8dp))
                NutriTextDescription(descTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri Grid Type 7 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriGridType7(imageUrlContent: String) {
    Card(
        shape = RoundedCornerShape(nutri_dimen_8dp),
        modifier = Modifier
            .padding(end = nutri_dimen_16dp, top = nutri_dimen_16dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(nutri_dimen_16dp)
        ) {
            Column {
                NutriImageUrlDesktop(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.height(150.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}