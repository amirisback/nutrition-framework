package com.frogobox.nutritioncore.sources

import com.google.gson.Gson
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/*
 * Created by faisalamir on 26/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
abstract class NutriLocalObserver<M> : SingleObserver<M> {

    abstract fun onCallbackSucces(data: M)
    abstract fun onCallbackError(code: Int, errorMessage: String)
    abstract fun onAddSubscribe(disposable: Disposable)

    override fun onSuccess(t: M) {
        if (t == null) {
            onCallbackError(200, "Data is empty")
        } else {
            onCallbackSucces(t)
        }
    }

    override fun onSubscribe(d: Disposable) {
        onAddSubscribe(d)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                val code = e.code()
                var msg = e.message()
                var baseDao: NutriApiModel<M>? = null
                try {
                    val body = e.response()?.errorBody()
                    baseDao = Gson().fromJson<NutriApiModel<M>>(
                        body!!.string(),
                        NutriApiModel::class.java
                    )
                } catch (exception: Exception) {
                    onCallbackError(code, exception.message!!)
                }

                when (code) {
                    504 -> {
                        msg = baseDao?.message ?: "Error Response"
                    }
                    502, 404 -> {
                        msg = baseDao?.message ?: "Error Connect or Resource Not Found"
                    }
                    400 -> {
                        msg = baseDao?.message ?: "Bad Request"
                    }
                    401 -> {
                        msg = baseDao?.message ?: "Not Authorized"
                    }
                }

                onCallbackError(code, msg)
            }

            is UnknownHostException -> onCallbackError(
                -1,
                "Telah terjadi kesalahan ketika koneksi ke server: ${e.message}"
            )
            is SocketTimeoutException -> onCallbackError(
                -1,
                "Telah terjadi kesalahan ketika koneksi ke server: ${e.message}"
            )
            else -> onCallbackError(-1, e.message ?: "Unknown error occured")
        }
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}