package com.frogobox.nutritionframework.lib.notification

import android.app.PendingIntent
import androidx.core.app.NotificationCompat

/*
 * Created by Faisal Amir on 28/12/2020
 * Notification Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface INutriNotification {

    // Intialize for Channel ID
    fun setChannelId(channelId: String): NutriNotification.Inject

    // Initialize for Channel Name
    fun setChannelName(channelName: String): NutriNotification.Inject

    // Initialize for Content Intent
    fun setContentIntent(intent: PendingIntent): NutriNotification.Inject

    // Initialize for Small Icon
    fun setSmallIcon(smallIcon: Int): NutriNotification.Inject

    // Initialize for Large Icon
    fun setLargeIcon(largeIcon: Int): NutriNotification.Inject

    // Initialize for Content Title
    fun setContentTitle(contentTitle: CharSequence): NutriNotification.Inject

    // Initialize for Content Text
    fun setContentText(contentText: CharSequence): NutriNotification.Inject

    // Initialize for Sub Text
    fun setSubText(contentSubText: CharSequence): NutriNotification.Inject

    // Initialize for Auto Cancel
    fun setupAutoCancel(): NutriNotification.Inject

    // Initialize for Style
    fun setStyle(style: NotificationCompat.Style): NutriNotification.Inject

    // Initialize for Show When
    fun setupShowWhen(): NutriNotification.Inject

    // Initialize for Group
    fun setGroup(groupKey: String): NutriNotification.Inject

    // Initialize for Group Summary
    fun setGroupSummary(): NutriNotification.Inject

    // Setup Vibration
    fun setupWithVibration(): NutriNotification.Inject

    // Setup Action Remote Input (Reply Usually)
    fun setupActionRemoteInput(listener: NutriNotifActionRemoteInputListener): NutriNotification.Inject

    // Setup Inbox Style (For Stack Notification)
    fun setupInboxStyle(listener: NutriNotifInboxStyleListener): NutriNotification.Inject

    // Setup Custom Content View
    fun setCustomContentView(listener: NutriNotifCustomContentViewListener): NutriNotification.Inject

    // Setup Big Custom Content View
    fun setCustomBigContentView(listener: NutriNotifCustomContentViewListener): NutriNotification.Inject

    // Setup Frogo Simple Style Notification
    fun setupWithFrogoStyle(): NutriNotification.Inject

    // Build the Frogo Notification
    fun build(): NutriNotification.Inject

    // Notify the Frogo Notification
    fun launch(notificationId: Int)

}