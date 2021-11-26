package com.frogobox.nutritionapp.util

import android.Manifest
import android.os.Environment
import com.frogobox.nutritionapp.BuildConfig
import com.frogobox.nutritionapp.model.People

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
object Constant {

    const val FULL_NAME = "Muhammad Faisal Amir"

    fun dummyData(cons : String): MutableList<People> {
        val listString = mutableListOf<People>()
        for (i in 1..5) {
            listString.add(People(cons, ""))
        }
        return listString
    }

    object TitleActivity {
        const val ACTIVITY_UI_COMPONENT = "UI Component"
        const val ACTIVITY_UI_XML_RV = "Item List RecyclerView"
        const val ACTIVITY_UI_COMPOSE = "Compose (Experimental)"

        const val ACTIVITY_ANDROID_METHOD = "Android Method Function"
        const val ACTIVITY_ANDROID_METHOD_RV = "Nutri RecyclerView"
        const val ACTIVITY_ANDROID_METHOD_LOG = "Nutri Log"
        const val ACTIVITY_ANDROID_METHOD_NOTIF = "Nutri Notification"
        const val ACTIVITY_ANDROID_METHOD_ADMOB = "Nutri Admob"
        const val ACTIVITY_ANDROID_METHOD_API_NEWS = "Consumable Nutri News API"
        const val ACTIVITY_ANDROID_METHOD_API_MEALS = "Consumable Nutri Meals API"

        const val ACTIVITY_ARTICLE = "Informasi Seputar Gizi"

        const val ACTIVITY_NUTRITION_ARTICLE = "Informasi Seputar Nutrisi"
        const val ACTIVITY_NUTRITION_ARTICLE_DETAIL = "Detail Informasi Nutrisi"

        const val ACTIVITY_CALCULATOR_BERAT_BADAN_IDEAL = "Kalkulator Berat Badan Ideal"
        const val ACTIVITY_CALCULATOR_KEBUTUHAN_ENERGI = "Kalkulator Kebutuhan Energi"
        const val ACTIVITY_CALCULATOR_INDEX_MASA_TUBUH = "Kalkulator Index Masa Tubuh"

        const val ACTIVITY_MEAL = "Informasi Resep Makanan"
        const val ACTIVITY_MEAL_DETAIL = "Detail Resep Makanan"

        const val ACTIVITY_VITAMIN = "Vitamin"
        const val ACTIVITY_VITAMIN_ARTICLE = "Informasi Seputar Vitamin"
        const val ACTIVITY_VITAMIN_ARTICLE_A = "Informasi Seputar Vitamin A"
        const val ACTIVITY_VITAMIN_ARTICLE_C = "Informasi Seputar Vitamin C"
        const val ACTIVITY_VITAMIN_ARTICLE_E = "Informasi Seputar Vitamin E"
        const val ACTIVITY_VITAMIN_ARTICLE_DETAIL = "Detail Informasi Vitamin"
        const val ACTIVITY_VITAMIN_PROBLEM = "Permasalahan Seputar Vitamin"
        const val ACTIVITY_VITAMIN_SOLVE = "Penyelesaian Masalah Vitamin"

        const val ACTIVITY_CALORIE_ARTICLE = "Informasi Seputar Kalori"
        const val ACTIVITY_CALORIE_ARTICLE_DETAIL = "Detail Informasi Kalori"

    }

    object Extra {
        const val BASE_EXTRA = BuildConfig.APPLICATION_ID

        const val EXTRA_ARTICLE_DETAIL = "$BASE_EXTRA.EXTRA_ARTICLE_DETAIL"
        const val EXTRA_ARTICLE_DETAIL_TITLE = "$BASE_EXTRA.EXTRA_ARTICLE_DETAIL_TITLE"
        const val EXTRA_ARTICLE = "$BASE_EXTRA.EXTRA_ARTICLE"
        const val EXTRA_ARTICLE_TITLE = "$BASE_EXTRA.EXTRA_ARTICLE_TITLE"

        const val EXTRA_MEAL_DETAIL = "$BASE_EXTRA.EXTRA_MEAL_DETAIL"
    }

    object Const {

        const val OPTION_GET = "OPTION_GET"
        const val OPTION_DELETE = "OPTION_DELETE"

        const val DEFAULT_NULL = "null"
        const val DEFAULT_ERROR_MESSAGE = "Failed"
        const val FRAGMENT_DIALOG = "dialog"

        const val SPLASH_INTERVAL = 1000

        const val EXTENSION_CSV = ".csv"
        const val BASE_PATH_RAW = "src/com/frogobox/raw"
        const val PATH_DATA_CSV = "/influencers$EXTENSION_CSV"
        const val PATH_RAW_CSV_DATA = BASE_PATH_RAW + PATH_DATA_CSV

    }

    object ApiUrl {
        const val NEWS_BASE_URL = "http://newsapi.org/"
        const val NEWS_API_KEY = "84d090d0537548ee8ac77620217b1b52"

        const val NEWS_BASE_PATH = "v2/"

        const val NEWS_PATH_TOP_HEADLINE = "top-headlines"
        const val NEWS_PATH_EVERYTHING = "everything"
        const val NEWS_PATH_SOURCES = "sources"

        const val NEWS_URL_TOP_HEADLINE = "$NEWS_BASE_PATH$NEWS_PATH_TOP_HEADLINE"
        const val NEWS_URL_EVERYTHING = "$NEWS_BASE_PATH$NEWS_PATH_EVERYTHING"
        const val NEWS_URL_SOURCES = "$NEWS_BASE_PATH$NEWS_PATH_SOURCES"
    }

    object RoomDatabase {
        val DATABASE_NAME = { BuildConfig.DATABASE_NAME }
        const val BASE_TABLE_NAME = "table"
        const val TABLE_NAME_FAVORITE = "favorite"
    }

    object TypeData {
        const val TYPE_INT = "TYPE_INT"
        const val TYPE_STRING = "TYPE_STRING"
        const val TYPE_FLOAT = "TYPE_FLOAT"
        const val TYPE_BOOLEAN = "TYPE_BOOLEAN"
        const val TYPE_OBJECT = "TYPE_OBJECT"
    }

    object Code {
        const val CODE_NAME = 1
        const val CODE_REQUEST_VIDEO_PERMISSIONS = 1
        val CODE_VIDEO_PERMISSIONS =
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)

    }

    object Arg {
        const val BASE_ARGUMENTS = BuildConfig.APPLICATION_ID
        const val ARGUMENTS_SCRIPT = "$BASE_ARGUMENTS.ARGUMENTS_SCRIPT"
        const val ARGUMENTS_EXAMPLE_SCRIPT = "$BASE_ARGUMENTS.ARGUMENTS_EXAMPLE_SCRIPT"
        const val ARGUMENTS_FAVORITE_SCRIPT = "$BASE_ARGUMENTS.ARGUMENTS_FAVORITE_SCRIPT"
    }

    object Pref {
        const val PREF_NAME = "BaseMusicPlayer"
    }

    object Value {
        const val VALUE_SENSOR_ORIENTATION_DEFAULT_DEGREES = 90
        const val VALUE_SENSOR_ORIENTATION_INVERSE_DEGREES = 270
    }

    object Tag {
        const val TAG_ACTIVITY_EDIT = 300
        const val TAG_ACTIVITY_CREATE = 301
        const val TAG_ACTIVITY_DETAIL = 302

        const val TAG_FROM_ACTIVITY = 801
        const val TAG_FROM_FRAGMENT = 800

        const val TAG_CAMERA_VIDEO = "Camera2VideoFragment"

    }

    object Ext {
        const val MP4 = ".mp4"
        const val PNG = ".png"
    }

    object Dir {
        const val BASE_FILE_NAME = "SPEECH_"
        const val BASE_DIR_NAME = "BaseMusicPlayer"
        val DIR_NAME = "${Environment.DIRECTORY_PICTURES}/$BASE_DIR_NAME"
        val VIDEO_FILE_NAME = "$BASE_FILE_NAME${System.currentTimeMillis()}${Ext.MP4}"
    }

}