package com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionframework.databinding.ActivityReplyBinding
import com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom.NotificationService.Companion.CHANNEL_ID
import com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom.NotificationService.Companion.CHANNEL_NAME
import com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom.NotificationService.Companion.REPLY_ACTION
import com.frogobox.nutritionframework.notification.NutriNotification

class ReplyActivity : BaseActivity<ActivityReplyBinding>() {

    companion object {
        private const val KEY_MESSAGE_ID = "key_message_id"
        private const val KEY_NOTIFY_ID = "key_notify_id"

        fun getReplyMessageIntent(context: Context, notifyId: Int, messageId: Int): Intent {
            val intent = Intent(context, ReplyActivity::class.java)
            intent.action = REPLY_ACTION
            intent.putExtra(KEY_MESSAGE_ID, messageId)
            intent.putExtra(KEY_NOTIFY_ID, notifyId)
            return intent
        }

    }

    private var mMessageId: Int = 0
    private var mNotifyId: Int = 0

    override fun setupViewBinding(): ActivityReplyBinding {
        return ActivityReplyBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {

        val intent = intent
        if (REPLY_ACTION == intent.action) {
            mMessageId = intent.getIntExtra(KEY_MESSAGE_ID, 0)
            mNotifyId = intent.getIntExtra(KEY_NOTIFY_ID, 0)
        }

        binding.buttonSend.setOnClickListener { sendMessage(mNotifyId, mMessageId) }
    }


    private fun sendMessage(notifyId: Int, messageId: Int) {
        updateNotification(notifyId)
        val message = binding.editReply.text.toString().trim { it <= ' ' }
        Toast.makeText(this, "Message ID: $messageId\nMessage: $message", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun updateNotification(notifyId: Int) {

        NutriNotification.Inject(this)
            .setChannelId(CHANNEL_ID)
            .setChannelName(CHANNEL_NAME as String)
            .setSmallIcon(R.drawable.ic_nutri_notification_notif)
            .setContentTitle(getString(R.string.notif_title_sent))
            .setContentText(getString(R.string.notif_content_sent))
            .setupWithVibration()
            .build()
            .launch(notifyId)
    }

}