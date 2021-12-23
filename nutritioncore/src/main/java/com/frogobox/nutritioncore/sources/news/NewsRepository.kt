package com.frogobox.nutritioncore.sources.news

import com.frogobox.nutritioncore.util.news.NewsUrl
import com.frogobox.nutritioncore.sources.NutriApiObserver
import com.frogobox.nutritioncore.sources.NutriApiClient
import com.frogobox.nutritioncore.sources.NutriResponse
import com.frogobox.nutritioncore.model.news.ArticleResponse
import com.frogobox.nutritioncore.model.news.SourceResponse
import io.reactivex.schedulers.Schedulers

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
object NewsRepository : NewsDataSource {

    private val TAG = NewsRepository::class.java.simpleName
    private var newsApiService = NutriApiClient.create<NewsApiService>(NewsUrl.BASE_URL, true)

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: NutriResponse.DataResponse<ArticleResponse>
    ) {
        newsApiService.getTopHeadline(apiKey, q, sources, category, country, pageSize, page)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<ArticleResponse>() {
                override fun onSuccess(data: ArticleResponse) {
                    if (data.articles?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun getEverythings(
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
        callback: NutriResponse.DataResponse<ArticleResponse>
    ) {
        newsApiService.getEverythings(
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
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<ArticleResponse>() {
                override fun onSuccess(data: ArticleResponse) {
                    if (data.articles?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: NutriResponse.DataResponse<SourceResponse>
    ) {
        newsApiService.getSources(apiKey, language, country, category)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiObserver<SourceResponse>() {
                override fun onSuccess(data: SourceResponse) {
                    if (data.sources?.size == 0) {
                        callback.onEmpty()
                    } else {
                        callback.onSuccess(data)
                    }
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}