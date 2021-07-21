package com.frogobox.app.util

import android.Manifest
import android.os.Environment
import com.frogobox.app.BuildConfig

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

    object Extra {
        const val BASE_EXTRA = BuildConfig.APPLICATION_ID
        const val EXTRA_OPTION = "$BASE_EXTRA.EXTRA_OPTION"
        const val EXTRA_FASHION = "$BASE_EXTRA.EXTRA_FASHION"
        const val EXTRA_FAVORITE_SCRIPT = "$BASE_EXTRA.EXTRA_FAVORITE_SCRIPT"
        const val EXTRA_EXAMPLE_SCRIPT = "$BASE_EXTRA.EXTRA_EXAMPLE_SCRIPT"
        const val EXTRA_CATEGORY = "$BASE_EXTRA.EXTRA_CATEGORY"
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
        val DATABASE_NAME = {BuildConfig.DATABASE_NAME}
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
        val CODE_VIDEO_PERMISSIONS = arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)

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

    object NewsConstant {

        const val QUERY_API_KEY = "apiKey"
        const val QUERY_SOURCES = "sources"
        const val QUERY_CATEGORY = "category"
        const val QUERY_Q = "q"
        const val QUERY_Q_IN_TITLE = "qInTitle"
        const val QUERY_LANGUAGE = "language"
        const val QUERY_COUNTRY = "country"
        const val QUERY_PAGE_SIZE = "pageSize"
        const val QUERY_PAGE = "page"
        const val QUERY_DOMAINS = "domains"
        const val QUERY_EXCLUDE_DOMAINS = "excludeDomains"
        const val QUERY_FROM = "from"
        const val QUERY_TO = "to"
        const val QUERY_SORT_BY = "sortBy"

        const val CATEGORY_BUSINESS = "business"
        const val CATEGORY_ENTERTAIMENT = "entertainment"
        const val CATEGORY_GENERAL = "general"
        const val CATEGORY_HEALTH = "health"
        const val CATEGORY_SCIENCE = "science"
        const val CATEGORY_SPORTS = "sports"
        const val CATEGORY_TECHNOLOGY = "technology"

        const val COUNTRY_AE = "ae"
        const val COUNTRY_AR = "ar"
        const val COUNTRY_AT = "at"
        const val COUNTRY_AU = "au"
        const val COUNTRY_BE = "be"
        const val COUNTRY_BG = "bg"
        const val COUNTRY_BR = "br"
        const val COUNTRY_CA = "ca"
        const val COUNTRY_CH = "ch"
        const val COUNTRY_CN = "cn"
        const val COUNTRY_CO = "co"
        const val COUNTRY_CU = "cu"
        const val COUNTRY_CZ = "cz"
        const val COUNTRY_DE = "de"
        const val COUNTRY_EG = "eg"
        const val COUNTRY_FR = "fr"
        const val COUNTRY_GB = "gb"
        const val COUNTRY_GR = "gr"
        const val COUNTRY_HK = "hk"
        const val COUNTRY_HU = "hu"
        const val COUNTRY_ID = "id"
        const val COUNTRY_IE = "ie"
        const val COUNTRY_IL = "il"
        const val COUNTRY_IN = "in"
        const val COUNTRY_IT = "it"
        const val COUNTRY_JP = "jp"
        const val COUNTRY_KR = "kr"
        const val COUNTRY_LT = "lt"
        const val COUNTRY_LV = "lv"
        const val COUNTRY_MA = "ma"
        const val COUNTRY_MX = "mx"
        const val COUNTRY_MY = "my"
        const val COUNTRY_NG = "ng"
        const val COUNTRY_NL = "nl"
        const val COUNTRY_NO = "no"
        const val COUNTRY_NZ = "nz"
        const val COUNTRY_PH = "ph"
        const val COUNTRY_PL = "pl"
        const val COUNTRY_PT = "pt"
        const val COUNTRY_RO = "ro"
        const val COUNTRY_RS = "rs"
        const val COUNTRY_RU = "ru"
        const val COUNTRY_SA = "sa"
        const val COUNTRY_SE = "se"
        const val COUNTRY_SG = "sg"
        const val COUNTRY_SI = "si"
        const val COUNTRY_SK = "sk"
        const val COUNTRY_TH = "th"
        const val COUNTRY_TR = "tr"
        const val COUNTRY_TW = "tw"
        const val COUNTRY_UA = "ua"
        const val COUNTRY_US = "us"
        const val COUNTRY_VE = "ve"
        const val COUNTRY_ZA = "za"

    }

}