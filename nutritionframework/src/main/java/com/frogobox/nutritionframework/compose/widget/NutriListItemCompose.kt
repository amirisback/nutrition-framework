package com.frogobox.nutritionframework.compose.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.frogobox.nutritioncore.compose.ui.*
import com.frogobox.nutritioncore.compose.widget.NutriTextDescription
import com.frogobox.nutritioncore.compose.widget.NutriTextSubTitle
import com.frogobox.nutritioncore.compose.widget.NutriTextTitle


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
// Nutri List Type 4 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType4(imageUrlContent: String, titleTextContent: String, isAndroid: Boolean) {
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                NutriImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(nutri_dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_16dp))
                NutriTextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 5 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType5(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    isAndroid: Boolean
) {
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                NutriImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(nutri_dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_16dp))
                Column {
                    NutriTextTitle(titleTextContent)
                    NutriTextSubTitle(subTitleTextContent)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 6 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType6(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String,
    isAndroid: Boolean
) {
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                NutriImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(width = nutri_dimen_72dp, height = nutri_dimen_96dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_16dp))
                Column {
                    NutriTextTitle(titleTextContent)
                    NutriTextSubTitle(subTitleTextContent)
                    Spacer(modifier = Modifier.size(nutri_dimen_16dp))
                    NutriTextDescription(descTitleTextContent)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 7 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType7(imageUrlContent: String, titleTextContent: String, isAndroid: Boolean) {
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                NutriCircleImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(nutri_dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_16dp))
                NutriTextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 8 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType8(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    isAndroid: Boolean
) {
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                NutriCircleImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier.size(nutri_dimen_48dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_16dp))
                Column {
                    NutriTextTitle(titleTextContent)
                    NutriTextSubTitle(subTitleTextContent)
                }
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 9 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType9(imageUrlContent: String, titleTextContent: String, isAndroid: Boolean) {
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
            Column {
                NutriImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(nutri_dimen_8dp))
                NutriTextTitle(titleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 10 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType10(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    isAndroid: Boolean
) {
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
            Column {
                NutriImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
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
// Nutri List Type 11 Android
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType11(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String,
    isAndroid: Boolean
) {
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
            Column {
                NutriImageUrlAndroid(
                    url = imageUrlContent,
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
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