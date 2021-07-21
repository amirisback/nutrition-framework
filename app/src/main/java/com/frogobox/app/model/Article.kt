package com.frogobox.app.model

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
 * com.frogobox.frogonewsapi.data.model
 *
 */

data class Article(

    @SerializedName("source")
    var source: Source? = null,

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("urlToImage")
    var urlToImage: String? = null,

    @SerializedName("publishedAt")
    var publishedAt: String? = null,

    @SerializedName("content")
    var content: String? = null
)