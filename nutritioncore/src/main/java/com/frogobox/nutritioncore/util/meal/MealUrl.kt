package com.frogobox.nutritioncore.util.meal

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
object MealUrl {

    const val BASE_URL = "https://www.themealdb.com"
    const val BASE_PATH = "api/json/v1/"
    const val PATH_API = "{api_key}/"
    const val API_KEY = "1"

    const val URL_SEARCH_MEAL = "$BASE_PATH$PATH_API" + "search.php"
    const val URL_LOOKUP_MEAL = "$BASE_PATH$PATH_API" + "lookup.php"
    const val URL_RANDOM_MEAL = "$BASE_PATH$PATH_API" + "random.php"
    const val URL_CATEGORIES = "$BASE_PATH$PATH_API" + "categories.php"
    const val URL_LIST = "$BASE_PATH$PATH_API" + "list.php"
    const val URL_FILTER = "$BASE_PATH$PATH_API" + "filter.php"

}