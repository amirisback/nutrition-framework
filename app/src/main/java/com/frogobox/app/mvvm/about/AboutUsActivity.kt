package com.frogobox.app.mvvm.about

import android.os.Bundle
import com.frogobox.app.R
import com.frogobox.app.core.BaseActivity

class AboutUsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setupDetailActivity("")
    }
}
