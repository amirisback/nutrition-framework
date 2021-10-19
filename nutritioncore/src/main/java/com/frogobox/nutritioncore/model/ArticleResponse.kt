package com.frogobox.nutritioncore.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NewsApi
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoconsumeapi.news.data.response
 *
 */
data class ArticleResponse(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("totalResults")
    var totalResults: Int? = null,

    @SerializedName("code")
    var code: String? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("articles")
    var articles: List<Article>? = null

)