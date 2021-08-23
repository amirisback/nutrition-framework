package com.frogobox.appnutrition.di

import androidx.preference.PreferenceManager
import com.frogobox.appnutrition.source.FrogoDataRepository
import com.frogobox.appnutrition.source.local.FrogoAppDatabase
import com.frogobox.appnutrition.source.local.FrogoLocalDataSource
import com.frogobox.appnutrition.source.remote.FrogoRemoteDataSource
import com.frogobox.appnutrition.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/*
 * Created by Faisal Amir on 23/10/2020
 * KickStartProject Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

val repositoryModule = module {

    single {
        FrogoDataRepository(FrogoRemoteDataSource, get())
    }

    single {
        FrogoLocalDataSource(AppExecutors(), get(), get())
    }

    single {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }


    single {
        FrogoAppDatabase.getInstance(androidContext()).favoriteScriptDao()
    }


}