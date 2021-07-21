package com.frogobox.generalframework.source.remote

import android.content.Context
import com.frogobox.generalframework.model.ArticleResponse
import com.frogobox.generalframework.model.Favorite
import com.frogobox.generalframework.model.SourceResponse
import com.frogobox.generalframework.source.FrogoDataSource
import com.frogobox.generalframework.util.SingleFunc.Func.noAction

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
 * com.frogobox.publicspeakingbooster.source.remote
 *
 */
object FrogoRemoteDataSource : FrogoDataSource {

    private val frogoApiClient = FrogoApiClient

    override fun usingChuckInterceptor(context: Context) {
        frogoApiClient.usingChuckInterceptor(context)
    }

    override suspend fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoDataSource.GetRemoteCallback<ArticleResponse>
    ) {
        val serviceApiClient = frogoApiClient.getApiClient.getTopHeadline(
            apiKey,
            q,
            sources,
            category,
            country,
            pageSize,
            page
        )

        callback.onShowProgressDialog()
        if (serviceApiClient.isSuccessful) {
            if (serviceApiClient.body() != null) {
                callback.onSuccess(serviceApiClient.body()!!)
            } else {
                callback.onEmpty()
            }
            callback.onHideProgressDialog()
        } else {
            callback.onFailed(500, serviceApiClient.message())
            callback.onHideProgressDialog()
        }

    }

    override suspend fun getEverythings(
        apiKey: String,
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoDataSource.GetRemoteCallback<ArticleResponse>
    ) {
        val serviceApiClient = frogoApiClient.getApiClient.getEverythings(
            apiKey,
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page
        )
        callback.onShowProgressDialog()
        if (serviceApiClient.isSuccessful) {
            if (serviceApiClient.body() != null) {
                callback.onSuccess(serviceApiClient.body()!!)
            } else {
                callback.onEmpty()
            }
            callback.onHideProgressDialog()
        } else {
            callback.onFailed(500, serviceApiClient.message())
            callback.onHideProgressDialog()
        }
    }

    override suspend fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: FrogoDataSource.GetRemoteCallback<SourceResponse>
    ) {
        val serviceApiClient =
            frogoApiClient.getApiClient.getSources(apiKey, language, country, category)
        callback.onShowProgressDialog()
        if (serviceApiClient.isSuccessful) {
            if (serviceApiClient.body() != null) {
                callback.onSuccess(serviceApiClient.body()!!)
            } else {
                callback.onEmpty()
            }
            callback.onHideProgressDialog()
        } else {
            callback.onFailed(500, serviceApiClient.message())
            callback.onHideProgressDialog()
        }
    }


    override fun saveRoomFavorite(data: Favorite): Boolean {
        return noAction()
    }


    override fun getRoomFavorite(callback: FrogoDataSource.GetRoomDataCallBack<List<Favorite>>) {
        noAction()
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return noAction()
    }

    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return noAction()
    }

    override fun nukeRoomFavorite(): Boolean {
        return noAction()
    }


}