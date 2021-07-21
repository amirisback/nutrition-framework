package com.frogobox.generalframework.mvvm.about

import android.os.Bundle
import com.frogobox.generalframework.R
import com.frogobox.generalframework.core.BaseActivity

class AboutUsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
