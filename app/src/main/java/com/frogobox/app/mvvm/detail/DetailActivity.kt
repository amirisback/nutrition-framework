package com.frogobox.app.mvvm.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.app.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extra = intent.extras?.getString("EXTRA_DATA_ARTICLE")


    }
}