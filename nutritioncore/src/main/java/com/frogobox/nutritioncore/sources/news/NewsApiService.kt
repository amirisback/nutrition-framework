package com.frogobox.nutritioncore.sources.news

import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritioncore.util.news.NewsConstant
import com.frogobox.nutritioncore.util.news.NewsUrl.URL_EVERYTHING
import com.frogobox.nutritioncore.util.news.NewsUrl.URL_SOURCES
import com.frogobox.nutritioncore.util.news.NewsUrl.URL_TOP_HEADLINE
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-news-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoconsumeapi.news.data.source
 *
 */
interface NewsApiService {

    // Get Top Headline
    @GET(URL_TOP_HEADLINE)
    fun getTopHeadline(
        @Query(NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(NewsConstant.QUERY_Q) q: String?,
        @Query(NewsConstant.QUERY_SOURCES) sources: String?,
        @Query(NewsConstant.QUERY_CATEGORY) category: String?,
        @Query(NewsConstant.QUERY_COUNTRY) country: String?,
        @Query(NewsConstant.QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(NewsConstant.QUERY_PAGE) page: Int?
    ): Observable<ArticleResponse>

    // Get Everythings
    @GET(URL_EVERYTHING)
    fun getEverythings(
        @Query(NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(NewsConstant.QUERY_Q) q: String?,
        @Query(NewsConstant.QUERY_FROM) from: String?,
        @Query(NewsConstant.QUERY_TO) to: String?,
        @Query(NewsConstant.QUERY_Q_IN_TITLE) qInTitle: String?,
        @Query(NewsConstant.QUERY_SOURCES) sources: String?,
        @Query(NewsConstant.QUERY_DOMAINS) domains: String?,
        @Query(NewsConstant.QUERY_EXCLUDE_DOMAINS) excludeDomains: String?,
        @Query(NewsConstant.QUERY_LANGUAGE) language: String?,
        @Query(NewsConstant.QUERY_SORT_BY) sortBy: String?,
        @Query(NewsConstant.QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(NewsConstant.QUERY_PAGE) page: Int?
    ): Observable<ArticleResponse>

    // Get Sources
    @GET(URL_SOURCES)
    fun getSources(
        @Query(NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(NewsConstant.QUERY_LANGUAGE) language: String,
        @Query(NewsConstant.QUERY_COUNTRY) country: String,
        @Query(NewsConstant.QUERY_CATEGORY) category: String
    ): Observable<SourceResponse>

}