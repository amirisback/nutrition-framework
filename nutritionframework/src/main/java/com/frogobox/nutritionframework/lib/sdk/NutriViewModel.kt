package com.frogobox.nutritionframework.lib.sdk

import android.app.Application
import androidx.lifecycle.AndroidViewModel

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
abstract class NutriViewModel(application: Application) : AndroidViewModel(application) {
    var eventShowProgress = NutriLiveEvent<Boolean>()
    var eventEmptyData = NutriLiveEvent<Boolean>()
    var eventFailed = NutriLiveEvent<String>()
}