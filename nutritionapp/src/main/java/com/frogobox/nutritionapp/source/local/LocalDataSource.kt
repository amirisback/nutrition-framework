package com.frogobox.nutritionapp.source.local

import android.content.Context
import android.content.SharedPreferences
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritioncore.model.news.SourceResponse
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritionapp.source.local.dao.FavoriteDao
import com.frogobox.nutritionframework.core.NutriPreference
import com.frogobox.nutritionframework.util.AppExecutors
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

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
 * com.frogobox.publicspeakingbooster.source.local
 *
 */
class LocalDataSource(
    private val appExecutors: AppExecutors,
    private val sharedPreferences: NutriPreference,
    private val favoriteDao: FavoriteDao
) : DataSource {

    override fun savePrefSample(key: String, value: String) {
        sharedPreferences.savePrefString(key, value)
    }

    override fun getPrefSample(key: String): String {
        return sharedPreferences.loadPrefString(key)
    }

    override fun saveRoomFavorite(data: Favorite): Boolean {
        return true
    }

    override fun getRoomFavorite(callback: DataSource.GetRoomDataCallBack<List<Favorite>>) {

    }

    override fun updateRoomFavorite(
        tableId: Int,
        title: String,
        description: String,
        dateTime: String
    ): Boolean {
        return true
    }


    override fun deleteRoomFavorite(tableId: Int): Boolean {
        return true
    }

    override fun nukeRoomFavorite(): Boolean {
        return true
    }

    private
    var compositeDisposable: CompositeDisposable? = null

    fun addSubscribe(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
            compositeDisposable?.add(disposable)
        }
    }

}
