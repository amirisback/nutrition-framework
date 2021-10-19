package com.frogobox.nutritionframework.lib.sdk

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Environment
import android.os.Handler
import com.frogobox.nutritionframework.R
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.util.ArrayList

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
object NutriFunc : INutriFunc {

    val TAG = NutriFunc::class.java.simpleName

    override fun createDialogDefault(
        context: Context,
        title: String,
        message: String,
        listenerYes: () -> Unit,
        listenerNo: () -> Unit
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        // set message of alert dialog
        dialogBuilder.setMessage(message)
            // if the dialog is cancelable
            .setCancelable(false)
            .setPositiveButton(context.getText(R.string.dialog_button_yes)) { dialog, id ->
                // positive button text and action
                listenerYes()
            }
            .setNegativeButton(context.getText(R.string.dialog_button_no)) { dialog, id ->
                // negative button text and action
                dialog.cancel()
                listenerNo()
            }
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(title)
        // show alert dialog
        alert.show()
    }

    override fun noAction(): Boolean {
        return false
    }

    override fun isNetworkAvailable(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected) isConnected = true
        return isConnected
    }

    override fun <T> fetchRawData(mContext: Context, sourceRaw: Int): ArrayList<T> {
        val dataArrayList = ArrayList<T>()
        val rawDict = mContext.resources.openRawResource(sourceRaw)
        val reader = BufferedReader(InputStreamReader(rawDict))
        try {
            var column: T
            while (reader.readLine().also { column = it as T } != null) {
                dataArrayList.add(column)
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return dataArrayList
    }

    override fun <T> fetchRawData(mContext: Context, sourceRaw: Int, shuffle: Boolean): ArrayList<T> {
        val dataArrayList = ArrayList<T>()
        val rawDict = mContext.resources.openRawResource(sourceRaw)
        val reader = BufferedReader(InputStreamReader(rawDict))
        try {
            var column: T
            while (reader.readLine().also { column = it as T } != null) {
                dataArrayList.add(column)
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        dataArrayList.shuffle()
        return dataArrayList
    }

    override fun getJsonFromAsset(context: Context, filename: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(filename).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    inline fun <reified T> getParseArray(json: String?, typeToken: Type): T {
        val gson = GsonBuilder().create()
        return gson.fromJson(json, typeToken)
    }

    inline fun <reified T> getArrayFromJsonAsset(context: Context, filename: String): MutableList<T> {
        val listData = mutableListOf<T>()
        val rawJson = getJsonFromAsset(context, filename)
        val typeToken = object : TypeToken<List<T>>() {}.type
        val data: List<T> = getParseArray(rawJson, typeToken)
        listData.addAll(data)
        return listData
    }

    override fun getDrawableString(context: Context, nameResource: String): Int {
        return context.resources.getIdentifier(nameResource, "drawable", context.packageName)
    }

    override fun getRawString(context: Context, nameResource: String): Int {
        return context.resources.getIdentifier(nameResource, "raw", context.packageName)
    }

    override fun randomNumber(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }

    override fun waitingMoment(delay: Long, listener:() -> Unit) {
        Handler().postDelayed({ listener() }, delay)
    }

}