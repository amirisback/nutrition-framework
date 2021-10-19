package com.frogobox.api.news.util

/*
 * Created by faisalamir on 27/07/21
 * Consumable
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
object NewsUrl {

    const val BASE_URL = "https://newsapi.org/"
    const val API_KEY = "84d090d0537548ee8ac77620217b1b52"

    const val BASE_PATH = "v2/"

    const val PATH_TOP_HEADLINE = "top-headlines"
    const val PATH_EVERYTHING = "everything"
    const val PATH_SOURCES = "sources"

    const val URL_TOP_HEADLINE = "$BASE_PATH$PATH_TOP_HEADLINE"
    const val URL_EVERYTHING = "$BASE_PATH$PATH_EVERYTHING"
    const val URL_SOURCES = "$BASE_PATH$PATH_SOURCES"

}