package com.frogobox.generalframework.util.helper

import android.os.Build
import android.text.format.DateFormat
import com.frogobox.generalframework.util.helper.ConstHelper.Date.HOUR_MILLIS
import com.frogobox.generalframework.util.helper.ConstHelper.Date.MINUTE_MILLIS
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 19/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.util.helper
 *
 */
object DateHelper {

    fun getTimeStamp(): String {
        val simpleDateFormat = SimpleDateFormat(ConstHelper.Date.DATE_TIME_STANDARD, Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

    fun getTimeNow(): String {
        val simpleDateFormat = SimpleDateFormat(ConstHelper.Date.TIME_GENERAL_HH_MM_SS, Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

    fun getCurrentDate(format: String): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.format(Date())
    }

    fun dateTimeToTimeStamp(date: String?): Long {
        var timestamp: Long = 0
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat(ConstHelper.Date.DATE_TIME_GLOBAL, Locale.getDefault())
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

    fun getCurrentUTC(): String {
        val time = Calendar.getInstance().time
        val outputFmt = SimpleDateFormat(ConstHelper.Date.TIME_GENERAL_HH_MM_SS)
        outputFmt.timeZone = TimeZone.getTimeZone("UTC")
        return outputFmt.format(time)
    }

    fun timetoHour(date: String?): String {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat(ConstHelper.Date.TIME_GENERAL_HH_MM_SS)
        df.timeZone = tz

        return DateFormat.format(ConstHelper.Date.TIME_GENERAL_HH_MM_SS, df.parse(date)).toString()
    }

    fun dateTimeTZtoHour(date: String?): String {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat(ConstHelper.Date.DATE_TIME_GLOBAL)
        df.timeZone = tz

        return DateFormat.format("hh:mm aa", df.parse(date)).toString()
    }

    fun DateTimeMonth(date: String?): String {
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat(ConstHelper.Date.DATE_TIME_STANDARD)
        df.timeZone = tz

        return DateFormat.format("MMM yyyy", df.parse(date)).toString()
    }

    fun dateTimeSet(date: String?): String {
        return if (date != null) {
            try {
                val tz = TimeZone.getTimeZone("UTC")
                val df = SimpleDateFormat(ConstHelper.Date.DATE_TIME_STANDARD)
                df.timeZone = tz

                DateFormat.format("MM/yyyy", df.parse(date)).toString()
            } catch (ex: ParseException) {
                ""
            }
        } else {
            ""
        }
    }

    fun dateTimeProblem(date: String?): String {
        return if (date != null) {
            try {
                val tz = TimeZone.getTimeZone("UTC")
                val df = SimpleDateFormat(ConstHelper.Date.DATE_ENGLISH_YYYY_MM_DD)
                df.timeZone = tz

                DateFormat.format("MM/yyyy", df.parse(date)).toString()
            } catch (ex: ParseException) {
                ""
            }
        } else {
            ""
        }
    }

    fun getTimeAgo(time: Long): String? {

        var time = time
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }

        val now = System.currentTimeMillis()
        if (time <= 0) {
            return null
        }

        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            "Just Now"
        } else if (diff < 2 * MINUTE_MILLIS) {
            "A minute ago"
        } else if (diff < 50 * MINUTE_MILLIS) {
            (diff / MINUTE_MILLIS ).toString()+" minutes ago"
        } else if (diff < 90 * MINUTE_MILLIS) {
            "An hour ago"
        } else if (diff < 24 * HOUR_MILLIS) {
            if ((diff / HOUR_MILLIS).toString() == "1") {
                "An hour ago"
            } else {
                (diff / HOUR_MILLIS).toString() + " hours ago"
            }
        } else {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                DateFormat.format("dd MMM yy - hh:mm", time).toString()
            } else {
                DateFormat.format("dd MMM yy - HH:mm", time).toString()
            }
        }
    }

    fun compareDate(newDate: String): String? {
        val format = SimpleDateFormat(ConstHelper.Date.DATE_ENGLISH_YYYY_MM_DD)
        val oldDate = Calendar.getInstance().time
        val now = format.format(oldDate)
        var info = 0L
        try {
            info =  TimeUnit.DAYS.convert(format.parse(now).getTime() - format.parse(newDate).getTime(), TimeUnit.MILLISECONDS)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return when {
            info > 1L -> getDataChat(dateTimeToTimeStamp(newDate))
            info == 1L -> "Yesterday"
            else -> "Today"
        }
    }

    fun messageDate(newDate: String): String? {
        val format = SimpleDateFormat(ConstHelper.Date.DATE_ENGLISH_YYYY_MM_DD)
        val oldDate = Calendar.getInstance().time
        val now = format.format(oldDate)
        var info = 0L
        try {
            info =  TimeUnit.DAYS.convert(format.parse(now).getTime() - format.parse(newDate).getTime(), TimeUnit.MILLISECONDS)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return when {
            info > 1L -> getDataChat(dateTimeToTimeStamp(newDate))
            info == 1L -> "Yesterday"
            else -> dateTimeTZtoHour(newDate)
        }
    }

    fun getDataChat(time: Long): String? {

        var time = time
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }

        val now = System.currentTimeMillis()
        if (time <= 0) {
            return null
        }

        val diff = now - time
        return if (diff < 24 * HOUR_MILLIS) {
            "Today"
        } else {
            DateFormat.format(ConstHelper.Date.DATE_DD_MM_YYYY_CLEAR, time).toString()
        }
    }

    fun convertClassificationDate(string: String?) : String {
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

    fun convertDateNewFormat(string: String?) : String {
        val formatter = SimpleDateFormat(ConstHelper.Date.DATE_ENGLISH_YYYY_MM_DD)
        val date = formatter.parse(string) as Date
        val newFormat = SimpleDateFormat("dd-MM-yy", Locale("EN"))
        val finalString = newFormat.format(date)
        return finalString
    }

    fun convertLongDateNewFormat(string: String?) : String {
        val formatter = SimpleDateFormat(ConstHelper.Date.DATE_TIME_STANDARD)
        val date = formatter.parse(string) as Date
        val newFormat = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale("EN"))
        val finalString = newFormat.format(date)
        return finalString
    }

    fun revertFromLongDateNewFormat(string: String?) : String {
        val formatter = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale("EN"))
        val date = formatter.parse(string) as Date
        val newFormat = SimpleDateFormat(ConstHelper.Date.DATE_TIME_STANDARD)
        val finalString = newFormat.format(date)
        return finalString
    }

    fun convertTargetDate(string: String?) : String {
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

    fun diffTime(timeStart: String, timeEnd: String): Long {
        var min: Long = 0
        val diff: Long
        val format = SimpleDateFormat(ConstHelper.Date.TIME_GENERAL_HH_MM_SS)

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