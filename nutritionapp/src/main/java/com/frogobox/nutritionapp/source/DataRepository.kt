package com.frogobox.nutritionapp.source


import android.content.Context
import com.frogobox.nutritioncore.model.ArticleResponse
import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritioncore.model.SourceResponse
import com.frogobox.nutritionapp.source.local.LocalDataSource
import com.frogobox.nutritionapp.source.remote.RemoteDataSource

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * BaseMusicPlayer
 * Copyright (C) 18/08/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.source
 *
 */
open class DataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataSource {
    override fun usingChuckInterceptor(context: Context) {
        remoteDataSource.usingChuckInterceptor(context)
    }

    override suspend fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: DataSource.GetRemoteCallback<ArticleResponse>
    ) {
        remoteDataSource.getTopHeadline(
            apiKey,
            q,
            sources,
            category,
            country,
            pageSize,
            page,
            callback
        )
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
        callback: DataSource.GetRemoteCallback<ArticleResponse>
    ) {
        remoteDataSource.getEverythings(
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
            page,
            callback
        )
    }

    override suspend fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: DataSource.GetRemoteCallback<SourceResponse>
    ) {
        remoteDataSource.getSources(apiKey, language, country, category, callback)
    }

    override fun saveRoomFavorite(data: Favorite): Boolean {
        return localDataSource.saveRoomFavorite(data)
    }

    override fun getRoomFavorite(callback: DataSource.GetRoomDataCallBack<List<Favorite>>) {
        localDataSource.getRoomFavorite(callback)
    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return localDataSource.updateRoomFavorite(tableId, title, description, dateTime)
    }


    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return localDataSource.deleteRoomFavorite(tableId)
    }

    override fun nukeRoomFavorite(): Boolean {
        return localDataSource.nukeRoomFavorite()
    }

}