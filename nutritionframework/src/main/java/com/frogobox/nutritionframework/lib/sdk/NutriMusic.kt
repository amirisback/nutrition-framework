package com.frogobox.nutritionframework.lib.sdk

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

/*
 * Created by faisalamir on 29/08/21
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
object NutriMusic : INutriMusic {

    private val TAG = NutriMusic::class.java.simpleName

    lateinit var mediaPlayer: MediaPlayer

    override fun playMusic(context: Context, musicFile: Int) {
        mediaPlayer = MediaPlayer.create(context, musicFile)
        mediaPlayer.start()
        mediaPlayer.isLooping = true
        Log.d(TAG, "Playing Music : $musicFile")
    }

    override fun stopMusic() {
        mediaPlayer.stop()
        mediaPlayer.release()
        Log.d(TAG, "Music Has Been Stoped")
    }

    override fun pauseMusic() {
        mediaPlayer.pause()
        Log.d(TAG, "Music Has Been Paused")
    }

}