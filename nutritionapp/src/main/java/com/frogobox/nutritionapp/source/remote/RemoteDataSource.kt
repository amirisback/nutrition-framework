package com.frogobox.nutritionapp.source.remote

import android.content.Context
import com.frogobox.nutritioncore.util.news.NewsUrl
import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritioncore.core.NutriApiCallback
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritioncore.sources.news.NewsApiService
import com.frogobox.nutritionframework.core.NutriApiClient
import com.frogobox.nutritionframework.util.NutriSingleFunc.noAction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
object RemoteDataSource : DataSource {

    override fun saveRoomFavorite(data: Favorite): Boolean {
        return noAction()
    }


    override fun getRoomFavorite(callback: DataSource.GetRoomDataCallBack<List<Favorite>>) {
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