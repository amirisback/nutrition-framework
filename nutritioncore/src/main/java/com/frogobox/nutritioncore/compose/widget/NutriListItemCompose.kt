package com.frogobox.nutritioncore.compose.widget

import androidx.compose.foundation.layout.*
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
fun NutriListType1(titleTextContent: String) {
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
            NutriTextTitle(textContent = titleTextContent)
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 2
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType2(titleTextContent: String, subTitleTextContent: String) {
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
                NutriTextTitle(textContent = titleTextContent)
                NutriTextSubTitle(textContent = subTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 3
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType3(titleTextContent: String, subTitleTextContent: String, descTitleTextContent: String) {
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
                NutriTextTitle(textContent = titleTextContent)
                NutriTextSubTitle(textContent = subTitleTextContent)
                Spacer(Modifier.size(nutri_dimen_8dp))
                NutriTextDescription(textContent = descTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 4
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType4(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 5
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType5(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 6
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType6(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 7
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType7(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 8
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType8(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 9
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType9(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 10
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType10(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 11
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType11(titleTextContent: String) {
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
            //
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 12
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType12(titleTextContent: String) {
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
            //
        }
    }
}