package com.frogobox.nutritionapp.mvvm.androidmethod.log

import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutriLogSampleBinding
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.log.NutriLog

class NutriLogSampleActivity : BaseActivity<ActivityNutriLogSampleBinding>() {

    override fun setupViewBinding(): ActivityNutriLogSampleBinding {
        return ActivityNutriLogSampleBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Nutri Log")
        binding.apply {

            btnFlog.setOnClickListener {
                // Regular No Toast
                NLog.d("Debug")
                NLog.i("Info")
                NLog.v("Verbose")
                NLog.w("Warn")
                NLog.e("Error")
                NLog.d()
            }

            btnFlogToast.setOnClickListener {
                // Regular with Toast
                NLog.d("Debug", this@NutriLogSampleActivity)
                NLog.i("Info", this@NutriLogSampleActivity)
                NLog.v("Verbose", this@NutriLogSampleActivity)
                NLog.w("Warn", this@NutriLogSampleActivity)
                NLog.e("Error", this@NutriLogSampleActivity)
                NLog.d()
            }

            btnFrogolog.setOnClickListener {
                // Line Number and No Toast
                NutriLog.d("Debug")
                NutriLog.i("Info")
                NutriLog.v("Verbose")
                NutriLog.w("Warn")
                NutriLog.e("Error")
                NutriLog.d()
            }

            btnFrogologToast.setOnClickListener {
                // Line Numbar with Toast
                NutriLog.d("Debug", this@NutriLogSampleActivity)
                NutriLog.i("Info", this@NutriLogSampleActivity)
                NutriLog.v("Verbose", this@NutriLogSampleActivity)
                NutriLog.w("Warn", this@NutriLogSampleActivity)
                NutriLog.e("Error", this@NutriLogSampleActivity)
                NutriLog.d(this@NutriLogSampleActivity)
            }

        }
    }
}