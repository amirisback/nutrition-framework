package com.frogobox.nutritioncore.compose.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
/*
 * Created by faisalamir on 21/08/21
 * NutriRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 NutriBox Inc.      
 * All rights reserved
 *
 */


// -------------------------------------------------------------------------------------------------
// Nutri Lazy Column
// -------------------------------------------------------------------------------------------------

@Composable
fun <T> NutriLazyColumn(
    data: List<T>,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    content: @Composable() LazyItemScope.(data: T) -> Unit

) {
    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        flingBehavior = flingBehavior,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        reverseLayout = reverseLayout
    ) {
        items(data.size) { index ->
            content(data[index])
        }
    }
}


// -------------------------------------------------------------------------------------------------
// Nutri Lazy Row
// -------------------------------------------------------------------------------------------------

@Composable
fun <T> NutriLazyRow(
    data: List<T>,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    horizontalArrangement: Arrangement.Horizontal =
        if (!reverseLayout) Arrangement.Start else Arrangement.End,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    content: @Composable() LazyItemScope.(data: T) -> Unit
) {
    LazyRow(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        flingBehavior = flingBehavior,
        reverseLayout = reverseLayout
    ) {
        items(data.size) { index ->
            content(data[index])
        }
    }
}


// -------------------------------------------------------------------------------------------------
// Nutri Lazy Fixed Grid
// -------------------------------------------------------------------------------------------------

@ExperimentalFoundationApi
@Composable
fun <T> NutriLazyFixedGrid(
    data: List<T>,
    spanCount: Int,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable() LazyGridScope.(data: T) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        cells = GridCells.Fixed(spanCount)
    ) {
        items(data.size) { index ->
            content(data[index])
        }
    }
}


// -------------------------------------------------------------------------------------------------
// Nutri Lazy Adaptive Grid
// -------------------------------------------------------------------------------------------------

@ExperimentalFoundationApi
@Composable
fun <T> NutriLazyAdaptiveGrid(
    data: List<T>,
    minSize: Dp,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable() LazyGridScope.(data: T) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        cells = GridCells.Adaptive(minSize)
    ) {
        items(data.size) { index ->
            content(data[index])
        }
    }
}