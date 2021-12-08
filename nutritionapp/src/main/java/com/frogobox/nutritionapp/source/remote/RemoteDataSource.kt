package com.frogobox.nutritionapp.source.remote

import com.frogobox.nutritionapp.model.Favorite
import com.frogobox.nutritionapp.source.DataSource
import com.frogobox.nutritionframework.util.NutriSingleFunc.noAction

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

    override fun savePrefString(key: String, value: String) {
        noAction()
    }

    override fun savePrefLong(key: String, value: Long) {
        noAction()
    }

    override fun savePrefFloat(key: String, value: Float) {
        noAction()
    }

    override fun savePrefInt(key: String, value: Int) {
        noAction()
    }

    override fun savePrefBoolean(key: String, value: Boolean) {
        noAction()
    }

    override fun deletePref(key: String) {
        noAction()
    }

    override fun nukePref() {
        noAction()
    }

    override fun getPrefString(key: String): String {
        return ""
    }

    override fun getPrefLong(key: String): Long {
        return 0
    }

    override fun getPrefFloat(key: String): Float {
        return 0f
    }

    override fun getPrefInt(key: String): Int {
        return 0
    }

    override fun getPrefBoolean(key: String): Boolean {
        return false
    }

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