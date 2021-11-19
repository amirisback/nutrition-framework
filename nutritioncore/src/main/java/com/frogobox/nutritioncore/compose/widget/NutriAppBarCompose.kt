package com.frogobox.nutritioncore.compose.widget

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/*
 * Created by faisalamir on 19/11/21
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
// Nutri Simple Top App Bar
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriSimpleTopAppBar(titleContent: String, elevationContent: Dp?) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text = titleContent)
        },
        backgroundColor = MaterialTheme.colors.primarySurface)
}


// -------------------------------------------------------------------------------------------------
// Nutri Detail Top App Bar
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriDetailTopAppBar(titleContent: String, elevationContent: Dp?) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text = titleContent)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        })
}



//@Composable
//fun NutriSimpleTopAppBarSample(titleContent: String, elevationContent: Dp?) {
//    TopAppBar(
//        elevation = 4.dp,
//        title = {
//            Text(text = titleContent)
//        },
//        backgroundColor = MaterialTheme.colors.primarySurface,
//        navigationIcon = {
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.ArrowBack, null)
//            }
//        }, actions = {
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.Share, null)
//            }
//            IconButton(onClick = {/* Do Something*/ }) {
//                Icon(Icons.Filled.Settings, null)
//            }
//        })
//}