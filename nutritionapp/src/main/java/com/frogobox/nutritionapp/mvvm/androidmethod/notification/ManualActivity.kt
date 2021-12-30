package com.frogobox.nutritionapp.mvvm.androidmethod.notification

import android.os.Bundle
import android.widget.RemoteViews
import android.content.Intent
import android.app.PendingIntent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.frogobox.nutritionapp.NutriApplication
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityManualBinding

/*
 * Created by faisalamir on 19/08/21
 * FrogoNotification
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

class ManualActivity : BaseActivity<ActivityManualBinding>() {

    private val notificationManager: NotificationManagerCompat by lazy {
        NotificationManagerCompat.from(this)
    }

    override fun setupViewBinding(): ActivityManualBinding {
        return ActivityManualBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun showNotification() {

        val clickIntent = Intent(this, NutriNotificationReceiver::class.java)
        val clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0)

        val collapsedView = RemoteViews(packageName, R.layout.notification_collapsed)
        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!")

        val expandedView = RemoteViews(packageName, R.layout.notification_expanded)
        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.ic_android)
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent)

        val notification = NotificationCompat.Builder(this, NutriApplication.CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_android)
            .setCustomContentView(collapsedView)
            .setCustomBigContentView(expandedView) //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
            .build()

        notificationManager.notify(NutriApplication.NOTIFICATION_ID, notification)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {
            btnShow.setOnClickListener {
                showNotification()
            }
        }
    }


}