package com.frogobox.nutritionframework.util

import android.content.Context
import android.media.MediaPlayer

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
interface INutriMusic {

    fun playMusic(context: Context, musicFile: Int)

    fun stopMusic()

    fun pauseMusic()

    // Please Add Your Code Under This Line --------------------------------------------------------

}