package com.frogobox.app.source.remote

import android.content.Context
import com.frogobox.app.model.ArticleResponse
import com.frogobox.app.model.SourceResponse
import com.frogobox.app.util.Constant
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
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
 * com.frogobox.publicspeakingbooster.source.remote.network
 *
 */
interface FrogoApiClient {

    // Get Top Headline
    @GET(Constant.ApiUrl.NEWS_URL_TOP_HEADLINE)
    suspend fun getTopHeadline(
        @Query(Constant.NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(Constant.NewsConstant.QUERY_Q) q: String?,
        @Query(Constant.NewsConstant.QUERY_SOURCES) sources: String?,
        @Query(Constant.NewsConstant.QUERY_CATEGORY) category: String?,
        @Query(Constant.NewsConstant.QUERY_COUNTRY) country: String?,
        @Query(Constant.NewsConstant.QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(Constant.NewsConstant.QUERY_PAGE) page: Int?
    ): Response<ArticleResponse>

    // Get Everythings
    @GET(Constant.ApiUrl.NEWS_URL_EVERYTHING)
    fun getEverythings(
        @Query(Constant.NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(Constant.NewsConstant.QUERY_Q) q: String?,
        @Query(Constant.NewsConstant.QUERY_FROM) from: String?,
        @Query(Constant.NewsConstant.QUERY_TO) to: String?,
        @Query(Constant.NewsConstant.QUERY_Q_IN_TITLE) qInTitle: String?,
        @Query(Constant.NewsConstant.QUERY_SOURCES) sources: String?,
        @Query(Constant.NewsConstant.QUERY_DOMAINS) domains: String?,
        @Query(Constant.NewsConstant.QUERY_EXCLUDE_DOMAINS) excludeDomains: String?,
        @Query(Constant.NewsConstant.QUERY_LANGUAGE) language: String?,
        @Query(Constant.NewsConstant.QUERY_SORT_BY) sortBy: String?,
        @Query(Constant.NewsConstant.QUERY_PAGE_SIZE) pageSize: Int?,
        @Query(Constant.NewsConstant.QUERY_PAGE) page: Int?
    ): Response<ArticleResponse>

    // Get Sources
    @GET(Constant.ApiUrl.NEWS_URL_SOURCES)
    fun getSources(
        @Query(Constant.NewsConstant.QUERY_API_KEY) apiKey: String,
        @Query(Constant.NewsConstant.QUERY_LANGUAGE) language: String,
        @Query(Constant.NewsConstant.QUERY_COUNTRY) country: String,
        @Query(Constant.NewsConstant.QUERY_CATEGORY) category: String
    ): Response<SourceResponse>

    companion object Factory {

        private var isUsingChuckInterceptor = false
        private lateinit var context: Context

        fun usingChuckInterceptor(context: Context) {
            isUsingChuckInterceptor = true
            Factory.context = context
        }


        val getApiClient: FrogoApiClient by lazy {
            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = if (isUsingChuckInterceptor) {
                OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .addInterceptor(ChuckInterceptor(context))
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            } else {
                OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
            }

            Retrofit.Builder()
                .baseUrl(Constant.ApiUrl.NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mClient)
                .build().create(FrogoApiClient::class.java)
        }
    }

}