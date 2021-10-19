package com.frogobox.nutritionframework.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson

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

object NutriNavigation {

    lateinit var bundle: Any

    const val TYPE_INT = "TYPE_INT"
    const val TYPE_STRING = "TYPE_STRING"
    const val TYPE_FLOAT = "TYPE_FLOAT"
    const val TYPE_BOOLEAN = "TYPE_BOOLEAN"
    const val TYPE_OBJECT = "TYPE_OBJECT"

    object BundleHelper {

        fun <T> createBaseBundle(typeKey: String, extraKey: String, data: T): Bundle {
            val extraBundle = Bundle()
            when (typeKey) {
                TYPE_INT -> {
                    extraBundle.putInt(extraKey, data as Int)
                }
                TYPE_STRING -> {
                    extraBundle.putString(extraKey, data as String)
                }
                TYPE_FLOAT -> {
                    extraBundle.putFloat(extraKey, data as Float)
                }
                TYPE_OBJECT -> {
                    val extraData = Gson().toJson(data)
                    extraBundle.putString(extraKey, extraData)
                }
                TYPE_BOOLEAN -> {
                    extraBundle.putBoolean(extraKey, data as Boolean)
                }
            }
            return extraBundle
        }

        inline fun <reified T> getBaseBundle(
            activity: Activity,
            typeKey: String,
            extraKey: String
        ): T {
            when (typeKey) {
                TYPE_INT -> {
                    bundle = activity.intent.extras?.getInt(extraKey)!!
                }
                TYPE_STRING -> {
                    bundle = activity.intent.extras?.getString(extraKey)!!
                }
                TYPE_FLOAT -> {
                    bundle = activity.intent.extras?.getFloat(extraKey)!!
                }
                TYPE_OBJECT -> {
                    val extraBundle = activity.intent.extras?.getString(extraKey)
                    bundle = Gson().fromJson(extraBundle, T::class.java)!!
                }
                TYPE_BOOLEAN -> {
                    bundle = activity.intent.extras?.getBoolean(extraKey)!!
                }
            }
            return bundle as T
        }

        fun createOptionBundle(tag: Int, extraKey: String): Bundle {
            val extraBundle = Bundle()
            extraBundle.putInt(extraKey, tag)
            return extraBundle
        }

        fun getOptionBundle(activity: Activity, extraKey: String): Int {
            return activity.intent.extras?.getInt(extraKey)!!
        }

    }

    fun navigatorImplicit(
        context: Context, activityPackage: String, className: String,
        extras: Bundle? = null, clearStack: Boolean = false, option: Bundle? = null
    ) {
        val intent = Intent()
        Log.d("Activity Package", activityPackage)
        Log.d("className", className)
        try {
            extras?.let { intent.setClassName(activityPackage, className).putExtras(it) }
            option?.let { intent.setClassName(activityPackage, className).putExtras(it) }

            if (clearStack) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }

            context.startActivity(intent)

        } catch (e: Exception) {
            Toast.makeText(context, "Activity not found", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

}