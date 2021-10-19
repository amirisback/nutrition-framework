package com.frogobox.nutritionframework.util

import android.content.Context
import java.util.ArrayList

/*
 * Created by faisalamir on 28/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriSingleFunc {

    fun createDialogDefault(
        context: Context,
        title: String,
        message: String,
        listenerYes: () -> Unit,
        listenerNo: () -> Unit
    )

    fun noAction(): Boolean

    fun randomNumber(start: Int, end: Int): Int

    fun isNetworkAvailable(context: Context): Boolean?

    fun <T> fetchRawData(mContext: Context, sourceRaw: Int): ArrayList<T>

    fun <T> fetchRawData(mContext: Context, sourceRaw: Int, shuffle: Boolean): ArrayList<T>

    fun getJsonFromAsset(context: Context, filename: String): String?

    fun getDrawableString(context: Context, nameResource: String): Int

    fun getRawString(context: Context, nameResource: String): Int

    fun waitingMoment(delay: Long, listener:() -> Unit)

}