package com.frogobox.nutritionframework.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors

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
class DiskIOThreadExecutor : Executor {

    private val diskIO = Executors.newSingleThreadExecutor()

    override fun execute(command: Runnable) {
        diskIO.execute(command)
    }

}