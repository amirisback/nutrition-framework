package com.frogobox.generalframework.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Environment
import android.text.format.DateFormat
import com.frogobox.generalframework.BuildConfig
import com.frogobox.generalframework.R
import com.frogobox.generalframework.util.Constant.Dir.DIR_NAME
import com.frogobox.generalframework.util.Constant.Dir.VIDEO_FILE_NAME
import com.frogobox.generalframework.util.Constant.Pref.PREF_NAME
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PublicSpeakingBooster
 * Copyright (C) 16/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.publicspeakingbooster.helper
 *
 */
object SingleFunc{

    object Func {

        fun createFolderPictureVideo(){
            val videoFolder = Environment.getExternalStoragePublicDirectory(DIR_NAME)
            if (!videoFolder.exists()) {
                videoFolder.mkdirs()
            }
        }

        fun getVideoFilePath(): String {
            val dir = Environment.getExternalStoragePublicDirectory(DIR_NAME)
            return if (dir == null) {
                VIDEO_FILE_NAME
            } else {
                "${dir.absoluteFile}/$VIDEO_FILE_NAME"
            }
        }

        fun createDialogDefault(context: Context, title: String, message: String, listenerYes: ()-> Unit, listenerNo: ()-> Unit) {
            val dialogBuilder = AlertDialog.Builder(context)
            // set message of alert dialog
            dialogBuilder.setMessage(message)
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton(context.getText(R.string.dialog_button_yes), DialogInterface.OnClickListener {
                        dialog, id -> listenerYes()
                })
                // negative button text and action
                .setNegativeButton(context.getText(R.string.dialog_button_no), DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                        listenerNo()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle(title)
            // show alert dialog
            alert.show()
        }

        fun noAction() : Boolean {
            return true
        }

        fun isNetworkAvailable(context: Context): Boolean? {
            var isConnected: Boolean? = false // Initial Value
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnected) isConnected = true
            return isConnected
        }

        fun showVersion() : String {
            return "Version " + BuildConfig.VERSION_NAME
        }

        fun fetchData(mContext: Context, sourceRaw: Int): ArrayList<String?> {
            val dataArrayList = ArrayList<String?>()
            val res = mContext.resources
            val rawDict = res.openRawResource(sourceRaw)
            val reader = BufferedReader(InputStreamReader(rawDict))
            try {
                var column: String?
                while (reader.readLine().also { column = it } != null) {
                    dataArrayList.add(column)
                }
                reader.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            dataArrayList.shuffle()
            return dataArrayList
        }
        

    }

    object Preference {

        fun getSp(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        }

        object Save {
            fun savePrefFloat(sharedPreferences: SharedPreferences, constPref: String, data: Float) {
                sharedPreferences.edit().putFloat(constPref, data).apply()
            }

            fun savePrefInt(sharedPreferences: SharedPreferences, constPref: String, data: Int) {
                sharedPreferences.edit().putInt(constPref, data).apply()
            }

            fun savePrefString(sharedPreferences: SharedPreferences, constPref: String, data: String) {
                sharedPreferences.edit().putString(constPref, data).apply()
            }

            fun savePrefBoolean(sharedPreferences: SharedPreferences, constPref: String, data: Boolean) {
                sharedPreferences.edit().putBoolean(constPref, data).apply()
            }

            fun savePrefLong(sharedPreferences: SharedPreferences, constPref: String, data: Long) {
                sharedPreferences.edit().putLong(constPref, data).apply()
            }

        }

        object Delete {

            fun deletePref(sharedPreferences: SharedPreferences, constPref: String) {
                sharedPreferences.edit().remove(constPref).apply()
            }

        }

        object Load {

            fun loadPrefFloat(sharedPreferences: SharedPreferences, constPref: String): Float {
                return sharedPreferences.getFloat(constPref, 0f)
            }

            fun loadPrefString(sharedPreferences: SharedPreferences, constPref: String): String {
                return sharedPreferences.getString(constPref, "")!!
            }

            fun loadPrefInt(sharedPreferences: SharedPreferences, constPref: String): Int {
                return sharedPreferences.getInt(constPref, 0)
            }

            fun loadPrefLong(sharedPreferences: SharedPreferences, constPref: String): Long {
                return sharedPreferences.getLong(constPref, 0)
            }

            fun loadPrefBoolean(sharedPreferences: SharedPreferences, constPref: String): Boolean {
                return sharedPreferences.getBoolean(constPref, false)
            }

        }

    }

    object DateHelper {

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
        const val DAY_WITH_DATE_TIME_ENGLISH_FULL = "EEEE, MMMM dd yyyy HH:mm" // Monday, August 12 2018 12:12
        const val DAY_WITH_DATE_TIME_LOCALE_FULL = "EEEE, dd MMMM yyyy HH:mm" // Senin, 12 Agustus 2018 12:12

        fun getTimeStamp(): String {
            val simpleDateFormat = SimpleDateFormat(DATE_TIME_STANDARD, Locale.getDefault())
            return simpleDateFormat.format(Date())
        }

        fun getTimeNow(): String {
            val simpleDateFormat = SimpleDateFormat(TIME_GENERAL_HH_MM_SS, Locale.getDefault())
            return simpleDateFormat.format(Date())
        }

        fun getCurrentDate(format: String): String {
            val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
            return simpleDateFormat.format(Date())
        }

        fun getCurrentUTC(): String {
            val time = Calendar.getInstance().time
            val outputFmt = SimpleDateFormat(TIME_GENERAL_HH_MM_SS)
            outputFmt.timeZone = TimeZone.getTimeZone("UTC")
            return outputFmt.format(time)
        }

        fun timetoHour(date: String?): String {
            val tz = TimeZone.getTimeZone("UTC")
            val df = SimpleDateFormat(TIME_GENERAL_HH_MM_SS)
            df.timeZone = tz

            return DateFormat.format(TIME_GENERAL_HH_MM_SS, df.parse(date)).toString()
        }

        fun dateTimeToTimeStamp(date: String?): Long {
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

        fun dateTimeTZtoHour(date: String?): String {
            val tz = TimeZone.getTimeZone("UTC")
            val df = SimpleDateFormat(DATE_TIME_GLOBAL)
            df.timeZone = tz

            return DateFormat.format("hh:mm aa", df.parse(date)).toString()
        }

        fun dateTimeMonth(date: String?): String {
            val tz = TimeZone.getTimeZone("UTC")
            val df = SimpleDateFormat(DATE_TIME_STANDARD)
            df.timeZone = tz

            return DateFormat.format("MMM yyyy", df.parse(date)).toString()
        }

        fun dateTimeSet(date: String?): String {
            return if (date != null) {
                try {
                    val tz = TimeZone.getTimeZone("UTC")
                    val df = SimpleDateFormat(DATE_TIME_STANDARD)
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
                    val df = SimpleDateFormat(DATE_ENGLISH_YYYY_MM_DD)
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
                (diff / MINUTE_MILLIS).toString()+" minutes ago"
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
            val format = SimpleDateFormat(DATE_ENGLISH_YYYY_MM_DD)
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
            val format = SimpleDateFormat(DATE_ENGLISH_YYYY_MM_DD)
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
                DateFormat.format(DATE_DD_MM_YYYY_CLEAR, time).toString()
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
            val formatter = SimpleDateFormat(DATE_ENGLISH_YYYY_MM_DD)
            val date = formatter.parse(string) as Date
            val newFormat = SimpleDateFormat("dd-MM-yy", Locale("EN"))
            val finalString = newFormat.format(date)
            return finalString
        }

        fun convertLongDateNewFormat(string: String?) : String {
            val formatter = SimpleDateFormat(DATE_TIME_STANDARD)
            val date = formatter.parse(string) as Date
            val newFormat = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale("EN"))
            val finalString = newFormat.format(date)
            return finalString
        }

        fun revertFromLongDateNewFormat(string: String?) : String {
            val formatter = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale("EN"))
            val date = formatter.parse(string) as Date
            val newFormat = SimpleDateFormat(DATE_TIME_STANDARD)
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
            val format = SimpleDateFormat(TIME_GENERAL_HH_MM_SS)

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
    
}