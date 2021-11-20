package com.frogobox.nutritioncore.compose.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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
fun NutriListType3(
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
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
                NutriTextTitle(textContent = titleTextContent)
                NutriTextSubTitle(textContent = subTitleTextContent)
                Spacer(Modifier.size(nutri_dimen_8dp))
                NutriTextDescription(textContent = descTitleTextContent)
            }
        }
    }
}

// -------------------------------------------------------------------------------------------------
// Nutri List Type 4 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType4(imageUrlContent: String, titleTextContent: String) {
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
                NutriImageUrlDesktop(
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
// Nutri List Type 5 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType5(imageUrlContent: String, titleTextContent: String, subTitleTextContent: String) {
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
                NutriImageUrlDesktop(
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
// Nutri List Type 6 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType6(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
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
                NutriImageUrlDesktop(
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
// Nutri List Type 7 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType7(imageUrlContent: String, titleTextContent: String) {
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
                NutriImageUrlDesktop(
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
// Nutri List Type 8 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType8(imageUrlContent: String, titleTextContent: String, subTitleTextContent: String) {
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
                NutriImageUrlDesktop(
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
// Nutri List Type 9 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType9(imageUrlContent: String, titleTextContent: String) {
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
// Nutri List Type 10 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType10(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String
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
// Nutri List Type 11 Desktop
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType11(
    imageUrlContent: String,
    titleTextContent: String,
    subTitleTextContent: String,
    descTitleTextContent: String
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
// Nutri List Type 12
// -------------------------------------------------------------------------------------------------

@Composable
fun NutriListType12(titleTextContent: String) {
    Card(
        shape = RoundedCornerShape(nutri_dimen_8dp),
        modifier = Modifier
            .padding(start = nutri_dimen_16dp, end = nutri_dimen_16dp, top = nutri_dimen_16dp)
    ) {
        Box(
            modifier = Modifier
                .padding(nutri_dimen_16dp)
        ) {
            NutriTextTitle(titleTextContent)
        }
    }
}