package com.frogobox.nutritionapp.source


import com.frogobox.nutritionapp.model.Favorite
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
class DataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataSource {

    override fun savePrefString(key: String, value: String) {
        localDataSource.savePrefString(key, value)
    }

    override fun savePrefLong(key: String, value: Long) {
        localDataSource.savePrefLong(key, value)
    }

    override fun savePrefFloat(key: String, value: Float) {
        localDataSource.savePrefFloat(key, value)
    }

    override fun savePrefInt(key: String, value: Int) {
        localDataSource.savePrefInt(key, value)
    }

    override fun savePrefBoolean(key: String, value: Boolean) {
        localDataSource.savePrefBoolean(key, value)
    }

    override fun deletePref(key: String) {
        localDataSource.deletePref(key)
    }

    override fun nukePref() {
        localDataSource.nukePref()
    }

    override fun getPrefString(key: String): String {
        return localDataSource.getPrefString(key)
    }

    override fun getPrefLong(key: String): Long {
        return localDataSource.getPrefLong(key)
    }

    override fun getPrefFloat(key: String): Float {
        return localDataSource.getPrefFloat(key)
    }

    override fun getPrefInt(key: String): Int {
        return localDataSource.getPrefInt(key)
    }

    override fun getPrefBoolean(key: String): Boolean {
        return localDataSource.getPrefBoolean(key)
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