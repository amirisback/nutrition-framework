package com.frogobox.nutritionapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.frogobox.nutritionapp.di.repositoryModule
import com.frogobox.nutritionapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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

class NutriApplication : Application() {

    companion object {
        const val NOTIFICATION_ID = 2
        const val CHANNEL_ID = "CHANNEL_$NOTIFICATION_ID"
        const val CHANNEL_NAME = "CHANNEL_NAME_$CHANNEL_ID"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NutriApplication)
            androidLogger(Level.NONE)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }

    // Please Add Your Code Under This Line --------------------------------------------------------

}