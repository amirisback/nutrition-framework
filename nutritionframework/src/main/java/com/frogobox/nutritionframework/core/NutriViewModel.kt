package com.frogobox.nutritionframework.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.frogobox.nutritionframework.util.NutriSingleLiveEvent

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
    var eventShowProgress = NutriSingleLiveEvent<Boolean>()
    var eventEmptyData = NutriSingleLiveEvent<Boolean>()
    var eventFailed = NutriSingleLiveEvent<String>()
}