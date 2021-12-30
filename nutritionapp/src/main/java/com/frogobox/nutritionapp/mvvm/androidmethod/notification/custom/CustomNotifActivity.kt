package com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom

import android.content.Intent
import android.os.Bundle
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityCustomNotifBinding

class CustomNotifActivity : BaseActivity<ActivityCustomNotifBinding>() {

    override fun setupViewBinding(): ActivityCustomNotifBinding {
        return ActivityCustomNotifBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Custom Notif")
        binding.buttonShowNotification.setOnClickListener {
            startService(Intent(this, NotificationService::class.java))
        }
    }

}