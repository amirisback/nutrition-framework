package com.frogobox.nutritioncore

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/*
 * Created by faisalamir on 26/07/21
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
object NutriDate : INutriDate {

    val TAG = NutriDate::class.java.simpleName

    // Format Second
    const val SECOND_MILLIS = 1000
    const val MINUTE_MILLIS = 60 * SECOND_MILLIS
    const val HOUR_MILLIS = 60 * MINUTE_MILLIS
    const val DAY_MILLIS = 24 * HOUR_MILLIS

    // Format Date
    const val DATE_TIME_GLOBAL = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" //
    const val DATE_TIME_STANDARD = "yyyy-MM-dd HH:mm:ss" // 2018-10-02 12:12:12
    const val DATE_ENGLISH_YYYY_MM_DD = "yyyy-MM-dd" // 2018-10-02
    const val DATE_ENGLISH_YYYY_MM_DD_CLEAR = "yyyy MM dd" // 2018 10 02
    const val DATE_DD_MM_YYYY = "dd-MM-yyyy" // 02-10-2018
    const val DATE_EEEE_DD_MM_YYYY = "EEEE, dd MMMM yyyy" // 02-10-2018
    const val DATE_DD_MM_YYYY_CLEAR = "dd MM yyyy" // 02-10-2018

    // Format Time
    const val TIME_GENERAL_HH_MM_SS = "HH:mm:ss" // 12:12:12
    const val TIME_GENERAL_HH_MM = "HH:mm" // 12:12

    // Format Day
    const val DAY_WITH_DATE_TIME_ENGLISH = "EEE, MMM dd yyyy HH:mm" // Mon, Aug 12 2018 12:12
    const val DAY_WITH_DATE_TIME_LOCALE = "EEE, dd MMM yyyy HH:mm" // Sen, 12 Agt 2019 12:12
    const val DAY_WITH_DATE_TIME_ENGLISH_FULL =
        "EEEE, MMMM dd yyyy HH:mm" // Monday, August 12 2018 12:12
    const val DAY_WITH_DATE_TIME_LOCALE_FULL =
        "EEEE, dd MMMM yyyy HH:mm" // Senin, 12 Agustus 2018 12:12

    override fun getTimeStamp(): String {
        val simpleDateFormat = SimpleDateFormat(DATE_TIME_STANDARD, Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

    override fun getTimeNow(): String {
        val simpleDateFormat = SimpleDateFormat(TIME_GENERAL_HH_MM_SS, Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

    override fun getCurrentDate(format: String): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

    override fun dateTimeToTimeStamp(date: String?): Long {
        var timestamp: Long = 0
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat(DATE_TIME_GLOBAL, Locale.getDefault())
        df.timeZone = tz

        if (date != null) {
            try {
                timestamp = df.parse(date).time / 1000
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        } else {
            timestamp = Date().getTime() / 1000
        }
        return timestamp
    }

    override fun getCurrentUTC(): String {
        val time = Calendar.getInstance().time
        val outputFmt = SimpleDateFormat(TIME_GENERAL_HH_MM_SS, Locale.getDefault())
        outputFmt.timeZone = TimeZone.getTimeZone("UTC")
        return outputFmt.format(time)
    }

    override fun convertClassificationDate(string: String?): String {
        return if (string != null) {
            if (string.contains("/")) {
                val temp = string.split("/")
                temp[1] + "-" + temp[0] + "-01"
            } else {
                ""
            }
        } else {
            ""
        }
    }

    override fun convertDateNewFormat(string: String?): String {
        val formatter = SimpleDateFormat(DATE_ENGLISH_YYYY_MM_DD, Locale.getDefault())
        val date = formatter.parse(string) as Date
        val newFormat = SimpleDateFormat(DATE_DD_MM_YYYY, Locale("EN"))
        return newFormat.format(date)
    }

    override fun convertLongDateNewFormat(string: String?): String {
        val formatter = SimpleDateFormat(DATE_TIME_STANDARD, Locale.getDefault())
        val date = formatter.parse(string) as Date
        val newFormat = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale("EN"))
        return newFormat.format(date)
    }

    override fun revertFromLongDateNewFormat(string: String?): String {
        val formatter = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale("EN"))
        val date = formatter.parse(string) as Date
        val newFormat = SimpleDateFormat(DATE_TIME_STANDARD, Locale.getDefault())
        val finalString = newFormat.format(date)
        return finalString
    }

    override fun convertTargetDate(string: String?): String {
        return if (string != null) {
            if (string.contains("/")) {
                val temp = string.split("/")
                temp[1] + "-" + temp[0] + "-01 00:00:00"
            } else {
                ""
            }
        } else {
            ""
        }
    }

    override fun diffTime(timeStart: String, timeEnd: String): Long {
        var min: Long = 0
        val diff: Long
        val format = SimpleDateFormat(TIME_GENERAL_HH_MM_SS, Locale.getDefault())

        var d1: Date? = null
        var d2: Date? = null

        try {
            d1 = format.parse(timeStart)
            d2 = format.parse(timeEnd)

            diff = d2.time - d1.time
            min = diff / (60 * 1000)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return min
    }

}