package com.frogobox.nutritioncore.util

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
interface INutriDate {

    fun getTimeStamp(): String

    fun getTimeNow(): String

    fun getCurrentDate(format: String): String

    fun dateTimeToTimeStamp(date: String?): Long

    fun getCurrentUTC(): String

    fun convertClassificationDate(string: String?): String

    fun convertDateNewFormat(string: String?): String

    fun convertLongDateNewFormat(string: String?): String

    fun revertFromLongDateNewFormat(string: String?): String

    fun convertTargetDate(string: String?): String

    fun diffTime(timeStart: String, timeEnd: String): Long

}